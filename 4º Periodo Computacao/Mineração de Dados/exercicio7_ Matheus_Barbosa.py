#! python3
# coding: utf-8

"""
Exercicio VII
Distância Euclidiana
Matheus Barbosa Souza
4º Período

Respostas:

A - para K = 1, a classe é B.
    para K = 2, a classe é B.
    para K = 3, a classe é B.
    para K = 4, a classe é B.  # Mas no caso houve empate. Resolvi escolher uma.
    para K = 5, a classe é B.

B - Ela necessita de muito calculo,
    sendo que com o modulo da diferença
    já teria como obter o resultado.
    E tambem pode variar bastante,
    necessitando uma normalização dos dados.

C - ↓
"""

from math import sqrt


def main():
    """ Main Funcition """

    table = [[0, 250, 36, 'A'],
             [10, 150, 34, 'B'],
             [2, 90, 10, 'A'],
             [6, 78, 8, 'B'],
             [4, 20, 1, 'A'],
             [1, 170, 70, 'B'],
             [8, 160, 41, 'A'],
             [10, 180, 38, 'B']]
    print_table(table)

    while True:
        try:
            k_value = int(input('Informe o valor de K: '))
            if 0 <= k_value <= 8:
                break
            else:
                print('O valor de tem que ser de 0 à 8. Tente novamente.')
        except ValueError:
            print('São válidos apenas números inteiros. Tente novamente.')

    example = [6, 200, 45, '']
    result = result_list(table, example)   # Retorna a lista de resultados
    table = insert_result_in_table(table, result)  # Retorna a tabela com os resultados já inseridos

    print()
    print_table(table)

    if verify_class_k(table, k_value):
        example[3] = 'A'
        print(f'Resultado: {example}')
        print('O K é de classe A.')
    else:
        example[3] = 'B'
        print(f'Resultado: {example}')
        print('O K é de classe B.')


def result_list(table, example):
    """ Funcao que adiciona os resultados de cada distancia a uma lista """

    result = list()
    for line in table:  # Percorre toda a tabela e lê apenas uma lista por vez
        result.append(calc_distance(line, example))  # Adiciona o resultado de
                                                     # cada numero euclidiano em uma lista
    return result


def insert_result_in_table(table, result):
    """ Insere o resultado no primeiro indice de cada lista da tabela """

    for i in range(8):
        table[i].insert(0, result[i]) # Adiciona os resultados na tabela
    table.sort()  # Ordena a tabela do menor pro maior

    return table


def verify_class_k(table, k_value):
    """ Verifica a qual classe o valor de k pertence """

    count_class_a = count_class_b = 0

    for i in range(k_value):
        if table[i][4] == 'A':
            count_class_a += 1
        elif table[i][4] == 'B':
            count_class_b += 1

    return count_class_a > count_class_b


def calc_distance(point_a, point_b):
    """ Calcula a distancia euclidiana entre dois pontos """

    euclidean_distance = 0
    for i in range(3):
        distance = (point_a[i] - point_b[i])**2  # Formula principal da distancia euclidiana
        euclidean_distance += distance  # Itera cada numero para o resultado final

    return round(sqrt(euclidean_distance), 2)


def print_table(table):
    """ Printa a Tabela """

    print('Tabela de Dados:')
    for line in table:
        print(line)
    print()


if __name__ == "__main__":
    main()
