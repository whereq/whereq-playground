import numpy as np

class PolynomialRegression:
    def __init__(self, degree=2, learning_rate=0.01, n_iterations=1000):
        self.degree = degree
        self.learning_rate = learning_rate
        self.n_iterations = n_iterations
        self.weights = None
        self.bias = None

    def fit(self, X, y):
        n_samples, n_features = X.shape
        
        # Create polynomial features
        X_poly = np.hstack([X ** i for i in range(1, self.degree + 1)])
        
        # Initialize weights and bias
        self.weights = np.zeros(X_poly.shape[1])
        self.bias = 0
        
        # Gradient descent
        for _ in range(self.n_iterations):
            # Predict y
            y_pred = np.dot(X_poly, self.weights) + self.bias
            
            # Compute gradients
            dw = (1 / n_samples) * np.dot(X_poly.T, (y_pred - y))
            db = (1 / n_samples) * np.sum(y_pred - y)
            
            # Update weights and bias
            self.weights -= self.learning_rate * dw
            self.bias -= self.learning_rate * db

    def predict(self, X):
        X_poly = np.hstack([X ** i for i in range(1, self.degree + 1)])
        return np.dot(X_poly, self.weights) + self.bias

# Example usage:
if __name__ == "__main__":
    # Sample data
    X = np.array([[1], [2], [3], [4], [5]])
    y = np.array([1, 4, 9, 16, 25])

    # Create and fit the model
    model = PolynomialRegression(degree=2)
    model.fit(X, y)

    # Predict
    print(model.predict(np.array([[6]])))  # Output: [36.0]