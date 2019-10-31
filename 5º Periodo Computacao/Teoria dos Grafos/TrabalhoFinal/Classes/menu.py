#! python3
# coding: utf-8

"""Matheus Barbosa Souza e Rafael Sidnei"""


import subprocess as sp
from PIL import Image


class Menu:
    """Classe menu"""

    def __init__(self):
        self.vertice = 0
        self.opcao = 0


    def mostra_menu(self, grafo):
        """Mostrar o menu com todas as opcoes na tela"""

        while self.opcao != -1:
            grafo.mostra_dados(grafo.matriz)
            print('\t', end='')
            print('='*34)
            print('\t=', f'{"Menu":^30}', '=')
            print('\t', end='')
            print('='*34)
            print(f'\t| {"01 - Inserir vertice":<30}', '|')
            print(f'\t| {"02 - Inserir aresta":<30}', '|')
            print(f'\t| {"03 - Seu grafo é completo?":<30}', '|')
            print(f'\t| {"04 - Gerar grafo complementar":<30}', '|')
            print(f'\t| {"05 - Número de componentes":<30}', '|')
            print(f'\t| {"06 - Seu grafo é uma árvore?":<30}', '|')
            print(f'\t| {"07 - Busca em largura":<30}', '|')
            print(f'\t| {"08 - Busca em profundidade":<30}', '|')
            print(f'\t| {"09 - Algoritmo de Dijkstra":<30}', '|')
            print(f'\t| {"10 - Gerar grafo aleatório":<30}', '|')
            print(f'\t| {"11 - Visualizar grafo":<30}', '|')
            print(f'\t| {"-1 - Sair":<30}', '|')
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
                if grafo.dfs():
                    predecessor, tempo1, tempo2 = grafo.dfs()
                    print('\n\tPredecessores:\n')
                    for i in range(self.vertice):
                        print(f'\tV{i}', end='')
                    print()
                    for pi in predecessor:
                        print(f'\t{pi}', end='')
                    print('\n')
                    print('\n\tTempo inicial:\n')
                    for i in range(self.vertice):
                        print(f'\tV{i}', end='')
                    print()
                    for d in tempo1:
                        print(f'\t{d}', end='')
                    print('\n')
                    print('\n\tTempo final::\n')
                    for i in range(self.vertice):
                        print(f'\tV{i}', end='')
                    print()
                    for f in tempo2:
                        print(f'\t{f}', end='')
                    print('\n')
                else:
                    print('\t\tVértices inesistentes!')


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


            elif self.opcao == 11:
                if grafo.grafo_visual():
                    with Image.open('/home/matheus/Documentos/Faculdade/5º Periodo Computacao/' +
                    'Teoria dos Grafos/TrabalhoFinal/Imagens/grafo.png') as img:
                        img.show()
                else:
                    print('\t\tGrafo sem nenhum vertice.')


            elif self.opcao != -1:
                print('\t\tOpção inválida!')


            input('\n\tPressione ENTER para continuar...')
            sp.call('clear', shell=True)
