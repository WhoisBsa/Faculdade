#! python3
# coding: utf-8


import subprocess as sp


class Menu:
    def mostra_menu(self, g):
        self.vertice = 0
        self.op = -1

        while self.op != 0:
            g.mostra_dados()
            print('\t', end='')
            print('='*34)
            print('\t=', f'{"Menu":^30}', '=')
            print('\t', end='')
            print('='*34)
            print(f'\t| {"1 - Inserir vertice":<30}', '|')
            print(f'\t| {"2 - Inserir aresta":<30}', '|')
            print(f'\t| {"3 - Seu grafo é completo?":<30}', '|')
            print(f'\t| {"4 - Gerar grafo complementar":<30}', '|')
            print(f'\t| {"5 - Seu grafo é uma árvore?":<30}', '|')
            print(f'\t| {"6 - Busca em largura":<30}', '|')
            print(f'\t| {"7 - Busca em profundidade":<30}', '|')
            print(f'\t| {"8 - Gerar grafo aleatório":<30}', '|')
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
                if g.checa_arvore():
                    print('\t\tSeu grafo é uma árvore!')
                else:
                    print('\t\tSeu grafo não é uma árvore!')


            elif self.op == 6:
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


            elif self.op == 7:
                while True:
                    try:
                        indice = int(input('\t\tÍndice: '))
                        break
                    except (TypeError, ValueError):
                        print('\t\tValor inválido, use apenas números!\n')
                if g.busca_profundidade(indice):
                    pass
                else:
                    print('\t\tVértice inesistente!')


            elif self.op == 8:
                while True:
                    try:
                        tamanho = int(input('\tTamanho do grafo: '))
                        break
                    except (TypeError, ValueError):
                        print('\tValor inválido, use apenas números!\n')
                g.gera_aleatorio(tamanho)
            



            input('\n\tPressione ENTER para continuar...')
            sp.call('clear',shell=True)   