import numpy as np
import matplotlib.pyplot as plt
import pandas as pd

def softmax(W, df_transformed_input):
    Z = np.dot(np.array(W).T, df_transformed_input.T)
    exp_Z = np.exp(Z - np.max(Z, axis=0, keepdims=True))
    return exp_Z / np.sum(exp_Z, axis=0, keepdims=True)

def predict_prods(softmax_matrix):
    return np.argmax(softmax_matrix, axis=0)[0]