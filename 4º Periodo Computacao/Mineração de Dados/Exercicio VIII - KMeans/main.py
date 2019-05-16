#! python3
# coding: utf-8

"""
Exercicio 08 - Matheus Barbosa e Rafael Sidnei.
"""

# Utilizada para a leitura de dados da tabela
import pandas as pd
# Utilizada para a execução do algoritimo e agrupamento dos dados
from sklearn.cluster import KMeans


def main():
    """ Main Function """

    iris = pd.read_csv('database.csv')
    iris.head()
    print(iris)

    table = iris.iloc[:, 1:4].values  # Pega os dados necessários na base de dados

    # 3 clusters com centroides selecionados de forma aleatória
    kmeans = KMeans(n_clusters=3,
                    init='random')
    print('\n\nExecuta o algoritimo e agrupa os dados:\n')
    print(kmeans.fit(table))

    print('\n\nCentroides Gerados:\n')
    print(kmeans.cluster_centers_)  # Verificar os centroides gerados

    # Contém os valores de distância em relação a cada cluster
    print('\n\nTabela de Distancia:\n')
    distance = kmeans.fit_transform(table)
    print(distance)

    print('\n\nLabels:\n')
    labels = kmeans.labels_  # Retorna o código do cluster que a instância de dados foi atribuído
    print(labels)

if __name__ == "__main__":
    main()
    