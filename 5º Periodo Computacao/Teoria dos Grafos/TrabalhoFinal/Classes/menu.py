#! python3
# coding: utf-8

"""Matheus Barbosa Souza e Rafael Sidnei"""


import subprocess as sp


class Menu:
    """Classe menu"""

    def __init__(self):
        self.vertice = 0
        self.opcao = -1


    def mostra_menu(self, grafo):
        """Mostrar o menu com todas as opcoes na tela"""

        while self.opcao != 0:
            grafo.mostra_dados(grafo.matriz)
            print('\t', end='')
            print('='*34)
            print('\t=', f'{"Menu":^30}', '=')
            print('\t', end='')
            print('='*34)
            print(f'\t| {"1 - Inserir vertice":<30}', '|')
            print(f'\t| {"2 - Inserir aresta":<30}', '|')
            print(f'\t| {"3 - Seu grafo é completo?":<30}', '|')
            print(f'\t| {"4 - Gerar grafo complementar":<30}', '|')
            print(f'\t| {"5 - Número de componentes":<30}', '|')
            print(f'\t| {"6 - Seu grafo é uma árvore?":<30}', '|')
            print(f'\t| {"7 - Busca em largura":<30}', '|')
            print(f'\t| {"8 - Busca em profundidade":<30}', '|')
            print(f'\t| {"9 - Algoritmo de Dijkstra":<30}', '|')
            print(f'\t| {"10 - Gerar grafo aleatório":<30}', '|')
            print(f'\t| {"0 - Sair":<30}', '|')
            print('\t', end='')
            print('='*34)

            while True:
                try:
                    self.opcao = int(input('\tOpção: '))
                    break
                except (TypeError, ValueError):
                    print('\tOpção inválida, tente novamente!')

            print()


            if self.opcao == 1:
                grafo.inserir_vertice(self.vertice)
                self.vertice += 1


            elif self.opcao == 2:
                while True:
                    try:
                        inicio = int(input('\t\t1º vértice: '))
                        fim = int(input('\t\t2º vértice: '))
                        break
                    except (TypeError, ValueError):
                        print('\t\tValor inválido, tente novamente!\n')

                if grafo.inserir_aresta(inicio, fim):
                    print(f'\n\t\tArestas adicionadas. Vértices: {{{inicio}, {fim}}}')
                else:
                    print('\n\t\tNão foi possível adicionar aresta.')


            elif self.opcao == 3:
                if self.vertice == 0:
                    print('\t\tNenhum grafo existente, crie um.')
                elif grafo.checa_completo():
                    print('\t\tO seu grafo é completo.')
                else:
                    print('\t\tO seu grafo não é completo.')


            elif self.opcao == 4:
                print('\n\tGrafo complementar:')
                grafo.complementar()


            elif self.opcao == 5:
                print(f'\t\tO grafo possui {grafo.num_componentes()} componentes')


            elif self.opcao == 6:
                if grafo.checa_arvore():
                    print('\t\tSeu grafo é uma árvore!')
                else:
                    print('\t\tSeu grafo não é uma árvore!')


            elif self.opcao == 7:
                while True:
                    try:
                        indice = int(input('\t\tÍndice: '))
                        break
                    except (TypeError, ValueError):
                        print('\t\tValor inválido, use apenas números!\n')

                if grafo.busca_largura(indice):
                    pass
                else:
                    print('\t\tVértice inesistente!')


            elif self.opcao == 8:
                while True:
                    try:
                        indice = int(input('\t\tÍndice: '))
                        break
                    except (TypeError, ValueError):
                        print('\t\tValor inválido, use apenas números!\n')

                if grafo.dfs(indice):
                    print('\n\tO caminhamento em profundidade do vértice é:')
                    print(f'\n\t{grafo.dfs(indice)}')
                else:
                    print('\t\tVértice inesistente!')


            elif self.opcao == 9:
                while True:
                    try:
                        inicio = int(input('\t\t1º vértice: '))
                        fim = int(input('\t\t2º vértice: '))
                        break
                    except (TypeError, ValueError):
                        print('\t\tValor inválido, tente novamente!\n')

                grafo.dijkstra(inicio, fim)


            elif self.opcao == 10:
                while True:
                    try:
                        tamanho = int(input('\tTamanho do grafo: '))
                        break
                    except (TypeError, ValueError):
                        print('\tValor inválido, use apenas números!\n')

                grafo.grafoera_aleatorio(tamanho)


            input('\n\tPressione ENTER para continuar...')
            sp.call('clear', shell=True)
