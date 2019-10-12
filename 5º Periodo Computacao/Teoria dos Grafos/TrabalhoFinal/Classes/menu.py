#! python3
# coding: utf-8


import subprocess as sp


class Menu:
    def mostra_menu(self, g):
        self.vertice = 0
        self.op = -1

        while self.op != 0:
            g.mostra_dados(g.matriz)
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
                    self.op = int(input('\tOpção: '))
                    break
                except (TypeError, ValueError):
                    print('\tOpção inválida, tente novamente!')
                
            print()


            if self.op == 1:
                g.inserir_vertice(self.vertice)
                self.vertice += 1


            elif self.op == 2:
                while True:
                    try:
                        inicio = int(input('\t\t1º vértice: '))
                        fim = int(input('\t\t2º vértice: '))
                        break
                    except (TypeError, ValueError):
                        print('\t\tValor inválido, tente novamente!\n')
                
                if g.inserir_aresta(inicio, fim):
                    print(f'\n\t\tArestas adicionadas. Vértices: {{{inicio}, {fim}}}')
                else:
                    print('\n\t\tNão foi possível adicionar aresta.')


            elif self.op == 3:
                if self.vertice == 0:
                    print('\t\tNenhum grafo existente, crie um.')
                elif g.checa_completo():
                    print('\t\tO seu grafo é completo.')
                else:
                    print('\t\tO seu grafo não é completo.')


            elif self.op == 4:
                print('\n\tGrafo complementar:')
                g.complementar()


            elif self.op == 5:
                print(f'\t\tO grafo possui {g.num_componentes()} componentes')


            elif self.op == 6:
                if g.checa_arvore():
                    print('\t\tSeu grafo é uma árvore!')
                else:
                    print('\t\tSeu grafo não é uma árvore!')


            elif self.op == 7:
                while True:
                    try:
                        indice = int(input('\t\tÍndice: '))
                        break
                    except (TypeError, ValueError):
                        print('\t\tValor inválido, use apenas números!\n')

                if g.busca_largura(indice):
                    pass
                else:
                    print('\t\tVértice inesistente!')


            elif self.op == 8:
                while True:
                    try:
                        indice = int(input('\t\tÍndice: '))
                        break
                    except (TypeError, ValueError):
                        print('\t\tValor inválido, use apenas números!\n')

                if g.dfs(indice):
                    print('\n\tO caminhamento em profundidade do vértice é:')
                    print(f'\n\t{g.dfs(indice)}')
                else:
                    print('\t\tVértice inesistente!')


            elif self.op == 9:
                print('\t\tGerando grafo com pesos...')
                g.mostra_dados(g.gera_dijkstra())

                while True:
                    try:
                        inicio = int(input('\t\t1º vértice: '))
                        fim = int(input('\t\t2º vértice: '))
                        break
                    except (TypeError, ValueError):
                        print('\t\tValor inválido, tente novamente!\n')
                
                g.dijkstra(inicio, fim)


            elif self.op == 10:
                while True:
                    try:
                        tamanho = int(input('\tTamanho do grafo: '))
                        break
                    except (TypeError, ValueError):
                        print('\tValor inválido, use apenas números!\n')

                g.gera_aleatorio(tamanho)
            



            input('\n\tPressione ENTER para continuar...')
            sp.call('clear',shell=True)   