import numpy as np
import matplotlib.pyplot as plt
import pandas as pd

def parse_to_df(X_predict_label, columns):
    return pd.DataFrame([X_predict_label], columns=columns)

def transform_full_dimension(train_cols, X_predict_encode):
    input_cols = X_predict_encode.columns.to_list()
    input_values = X_predict_encode.iloc[0].values

    df_transformed_input = pd.DataFrame(np.zeros((1, len(train_cols))), columns=train_cols)

    for col, val in zip(input_cols, input_values):
        if val == 1 and col in df_transformed_input:
            df_transformed_input[col] = val

    return df_transformed_input

def one_hot_encode(df_input, columns_to_encode, valid_categories):
    """
    对指定的 DataFrame 列进行手动 One-Hot 编码。

    参数:
        df_input (pd.DataFrame): 原始数据的 DataFrame。
        columns_to_encode (list): 需要进行 One-Hot 编码的列名列表。

    返回:
        pd.DataFrame: 返回一个新的 DataFrame, 其中指定的列已完成 One-Hot 编码，未编码的列保持原样。
    """
    df_encoded = df_input.copy() # 创建一个副本，以避免修改原始 DataFrame
    all_new_columns = [] # 用于存储每个已编码列的 DataFrame 列表

    for col_name in columns_to_encode:
        if col_name not in df_encoded.columns:
            continue

        unique_categories = df_encoded[col_name].unique()
        # 对类别进行排序，以确保新生成的列顺序一致（如有需要）
        # 例如：['AVG', 'BEST', 'POOR'] 可以重新排序
        unique_categories = [cat for cat in df_encoded[col_name].unique() if cat in valid_categories]
        sorted_categories = sorted(unique_categories)

        # 为当前类别新生成的列创建临时 DataFrame
        col_encoded_df = pd.DataFrame(index=df_encoded.index)

        for category in sorted_categories:
            new_col_name = f"{col_name}_{category}"
            # 将原始值与类别匹配则赋值为1，否则赋值为0
            col_encoded_df[new_col_name] = (df_encoded[col_name] == category).astype(int)

        all_new_columns.append(col_encoded_df)

    # 移除已进行编码的原始列（df_encoded 中的这些列）
    df_encoded = df_encoded.drop(columns=columns_to_encode)

    # 将已编码的新列拼接到原始 DataFrame
    # 使用 pd.concat 将已编码的 DataFrame 与剩余的 df_encoded 拼接起来
    if all_new_columns: # 确保有新列可以拼接
        df_encoded = pd.concat([df_encoded] + all_new_columns, axis=1)

    return df_encoded