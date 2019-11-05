#! python3
# coding: utf-8

"""Matheus Barbosa Souza e Rafael Sidnei"""


from random import randint
import glob, os
import imageio
import pygraphviz as pgv
from PIL import Image


class Grafo:
    def __init__(self):
        self.vertices = []
        self.matriz = [[0]*0 for i in range(0)]
        self.predecessor = [None] * 0
        self.time = 0


    def mostra_dados(self, matriz):
        """Mostra o grafo na tela."""

        linha = coluna = len(matriz)
        print()
        for l in range(linha):
            for c in range(coluna):
                print(f'\t{matriz[l][c]}', end='')
            print()
        print('\n')


    def existe_vertice(self, v):
        """Retorna True se houver vértice na lista.\n
        Parâmetros: v - vértice a ser checado.\n
        Anotações: a lista chama o método count() que retorna o numero de ocorrências do 
        valor passado por parâmetro. Se for igual a 0 significa que não há vértice."""

        return self.vertices.count(v) != 0


    def inserir_vertice(self, v):
        """Função para adicionar vertice ao grafo.\n
        Parâmetros: v - vértice a ser adicionado.\n
        Anotações: cria-se uma matriz auxiliar adicionando uma coluna e uma linha a mais
        e recebe cada posição da matriz principal.\n
        Retorna True se não houver nenhum vértice igual"""

        self.vertices.append(v)
        linha = coluna = len(self.matriz)
        matriz_aux = [[0]*(linha+1) for i in range(coluna+1)]
        
        for l in range(linha):
            for c in range(coluna):
                matriz_aux[l][c] = self.matriz[l][c]
        self.matriz = matriz_aux


    def inserir_aresta(self, inicio, fim):
        """Função para adicionar arestas num par de vértices.\n
        Parâmetros: inicio - primeiro vértice, fim - segundo vértice.\n
        Anotações: é atribuido o valor 1 na posição da matriz determinada por inicio e fim."""
        if not(self.existe_vertice(inicio)) or not(self.existe_vertice(fim)):
            return False
        if inicio == fim:
            print('\n\t\tApenas grafos simples. Tente novamente')
            return False

        else:
            self.matriz[self.vertices.index(inicio)][self.vertices.index(fim)] = 1
            self.matriz[self.vertices.index(fim)][self.vertices.index(inicio)] = 1
        return True

    
    def checa_completo(self):
        """Checa se um grafo é completo ou não."""

        linha = coluna = len(self.matriz)
        
        for l in range(linha):
            for c in range(l+1, coluna):
                if self.matriz[l][c] == 0:
                    return False
        return True


    def complementar(self):
        """Cria o grafo complementar da matriz."""

        linha = coluna = len(self.matriz)
        matriz_aux = [[0]*(linha) for i in range(coluna)]
        
        for l in range(linha):
            for c in range(coluna):
                matriz_aux[l][c] = self.matriz[l][c]
                if l != c and matriz_aux[l][c] == 1:
                    matriz_aux[l][c] = 0
                elif l != c:
                    matriz_aux[l][c] = 1
        print()
        for l in range(linha):
            for c in range(coluna):
                print('\t', matriz_aux[l][c], end='')
            print()
        print('\n')


    def num_componentes(self):
        """Função para contar o numero de componentes do grafo."""

        componentes, _, _ = self.dfs()

        return componentes.count(None)


    def checa_arvore(self):
        """Função para verificar se o grafo é uma arvore."""

        if self.num_componentes() > 1:
            return False
        
        linha = len(self.matriz)
        visitado = [False] * linha

        for i in range(linha):
            if visitado[i] == False:
                if self.isCicle(i, visitado, -1):
                    return False
        
        return True


    def isCicle(self, u, visitado, visinho):
        """Função recursiva para verificar se há ciclo no grafo"""

        visitado[u] = True

        for v, i in enumerate(self.matriz[u]):
            if i == 1:
                if not visitado[v]:
                    if self.isCicle(v, visitado, u):
                        return True
                elif visinho != v:
                    return True

        return False


    def busca_largura(self, indice):
        """Busca em largura."""

        if not(self.existe_vertice(indice)):
            return False

        linha = len(self.matriz)
        f = 10


        # Criando grafo para executar a busa em largura
        grafoV = self.grafo_visual()
        node = grafoV.get_node(indice)
        node.attr['fillcolor'] = 'gray'

        for i in range(linha):
            node = grafoV.get_node(i)
            if i == indice:
                node.attr['label'] = '0'
            else:
                node.attr['label'] = '∞'
            node.attr['fontcolor'] = 'crimson'

        filename = f'grafo{f}.png'
        grafoV.layout(prog='dot')
        
        grafoV.draw('/home/matheus/Documentos/Faculdade/5º Periodo Computacao/' +
        'Teoria dos Grafos/TrabalhoFinal/Imagens/' + filename)


        cor = ['BRANCO'] * linha
        distancia = [999] * linha
        self.predecessor = [None] * linha
        
        cor[indice] = 'CINZA'
        distancia[indice] = 0
        self.predecessor[indice] = None
        fila = []
        fila.append(indice)

        while len(fila):
            u = fila.pop(0)
            node = grafoV.get_node(u)
            f += 1

            for v, i in enumerate(self.matriz[u]):
                if i == 1:
                    if cor[v] in 'BRANCO':
                        cor[v] = 'CINZA'
                        distancia[v] = distancia[u] + 1
                        self.predecessor[v] = u
                        fila.append(v)

                        f += 1
                        node = grafoV.get_node(v)
                        edge = grafoV.get_edge(u, v)
                        node.attr['fillcolor'] = 'gray'
                        node.attr['label'] = f'{distancia[v]}'
                        edge.attr['color'] = 'crimson'

                        filename = f'grafo{f}.png'
                        grafoV.layout(prog='dot')
                       
                        grafoV.draw('/home/matheus/Documentos/Faculdade/5º Periodo Computacao/' +
                        'Teoria dos Grafos/TrabalhoFinal/Imagens/' + filename)

            f += 1
            cor[u] = 'PRETO'
            node = grafoV.get_node(u)
            node.attr['fillcolor'] = 'black'

            filename = f'grafo{f}.png'
            grafoV.layout(prog='dot')
            
            grafoV.draw('/home/matheus/Documentos/Faculdade/5º Periodo Computacao/' +
            'Teoria dos Grafos/TrabalhoFinal/Imagens/' + filename)           


        print('\n\tPredecessores:\n')
        for i in range(linha):
            print(f'\tV{i}', end='')
        print()
        for pi in self.predecessor:
            print(f'\t{pi}', end='')
        print('\n')

        path = ('/home/matheus/Documentos/Faculdade/5º Periodo Computacao/' +
        'Teoria dos Grafos/TrabalhoFinal/Imagens/')

        files = [f for f in glob.glob(path + "*.png")]

        files.sort()
        images = []
        kargs = { 'duration': 2 }
        for filename in files:
            images.append(imageio.imread(filename))
            os.remove(filename)

        imageio.mimsave('/home/matheus/Documentos/Faculdade/5º Periodo Computacao/' +
            'Teoria dos Grafos/TrabalhoFinal/Imagens/grafo.gif', images, 'GIF', **kargs)

        return True


    def dfs(self):
        """Busca em profundidade."""

        linha = coluna = len(self.matriz)
        cor = ['BRANCO'] * linha
        self.predecessor = [None] * linha
        d = [None] * len(self.matriz)
        f = [None] * len(self.matriz)
        for u in self.vertices:
            if cor[u] in 'BRANCO':
                self.dfs_util(u, cor, d, f)

        self.time = 0

        return self.predecessor, d, f


    def dfs_util(self, u, cor, d, f):
        """Função recursiva do algorimo de busta em profundidade."""

        linha = coluna = len(self.matriz)
        cor[u] = 'CINZA'
        self.time += 1
        d[u] = self.time

        for v, i in enumerate(self.matriz[u]):
            if i == 1:
                if cor[v] in 'BRANCO':
                    self.predecessor[v] = u
                    self.dfs_util(v, cor, d, f)
        cor[u] = 'PRETO'
        self.time += 1
        f[u] = self.time

        return self.predecessor, d, f, cor


    def gera_dijkstra(self):
        """Cria o grafo baseado em pesos das arestas."""

        linha = coluna = len(self.matriz)
        matriz_dijkstra = [[0]*(linha) for i in range(coluna)]

        for l in range(linha):
            for c in range(coluna):
                matriz_dijkstra[l][c] = self.matriz[l][c]
                if matriz_dijkstra[l][c] == 1:  # troca onde for 1 por um peso aleatório
                    matriz_dijkstra[l][c] = randint(1, 10)
                    matriz_dijkstra[c][l] = matriz_dijkstra[l][c]

        return matriz_dijkstra


    def minDistancia(self, distancia, visitado):
        """Função para descobrir a menor distancia entre os vértices."""

        min = 999
        min_index = 0
        for v in range(len(self.matriz)):
            if distancia[v] < min and visitado[v] == False:
                min = distancia[v]
                min_index = v
    
        return min_index


    def dijkstra(self, inicio, fim):
        """Algoritmo de Dijkstra para descobrir o menor caminho."""

        if not(self.existe_vertice(inicio)) or not(self.existe_vertice(fim)):
            return False

        matriz_dijkstra = self.gera_dijkstra()
        self.mostra_dados(matriz_dijkstra)
        linha = len(matriz_dijkstra)

        distancia = [999] * linha
        self.predecessor = [None] * linha
        distancia[inicio] = 0
        visitado = [False] * linha
        
        for i in range(linha):
            u = self.minDistancia(distancia, visitado)
            
            visitado[u] = True

            for v in range(linha):
                if matriz_dijkstra[u][v] > 0 and visitado[v] == False and \
                    distancia[v] > distancia[u] + matriz_dijkstra[u][v]:
                    distancia[v] = distancia[u] + matriz_dijkstra[u][v]
                    self.predecessor[v] = u

        self.mostra_dijkstra(distancia, inicio, fim)

    
    def mostra_dijkstra(self, distancia, inicio, fim):
        """Mostra o resultado de todo o algoritmo de Dijkstra."""

        linha = len(self.matriz)
        caminho = []

        print(f'\t\t{"Vértices":<15}', end='')
        for i in range(linha):
            print(f'\tV{i}', end='')

        print(f'\n\t\t{"Predecessores:":<15}', end='')
        for l in range(linha):
            print(f'\t{self.predecessor[l]}', end='')

        print(f'\n\t\t{"Distância:":<15}', end='')
        for l in range(linha):
            print(f'\t{distancia[l]}', end='')
        print()

        fimaux = fim
        caminho.append(fim)

        while True:
            if self.predecessor[fimaux] != None:
                pred = self.predecessor[fimaux]
                caminho.append(pred)
                fimaux = pred
                if pred == inicio:
                    break
            else:
                caminho.append(f'Impossivel chegar até')
                break
                
        print(f'\n\t\tCaminho de {inicio} até {fim}: ', end='')
        print(caminho[::-1])
        print(f'\n\t\tDistância de {inicio} até {fim}: {distancia[fim]}')
      

    def gera_aleatorio(self, tamanho):
        """Função para gerar um grafo aleatório.\n
        Parâmetros: tamanho - determina qual será as dimensões do grafo.\n
        Anotações: seta a matriz aleatória numa metade e depois espelha na outra."""
        matriz = [[0]*tamanho for coluna in range(tamanho)]

        for i in range(tamanho):
            for j in range(i+1, tamanho):
                matriz[i][j] = randint(0,1)
                matriz[j][i] = matriz[i][j]
                
        linha = coluna = len(matriz)
        print()
        for l in range(linha):
            for c in range(coluna):
                print(f'\t{matriz[l][c]}', end='')
            print()
        print('\n')


    def grafo_visual(self):
        interface_grafo = pgv.AGraph()
        interface_grafo.graph_attr['label'] = '\nTeoria dos Grafos\nMatheus Barbosa e Rafael Sidnei'
        interface_grafo.graph_attr['dpi'] = 200
        interface_grafo.graph_attr['bgcolor'] = 'mediumturquoise'
        interface_grafo.node_attr['shape']  = 'circle'
        interface_grafo.node_attr['style']  = 'filled'
        interface_grafo.node_attr['fillcolor']  = 'white'
        interface_grafo.node_attr['fontcolor']  = 'white'

        
        linha = coluna = len(self.matriz)

        if linha == 0:
            return False

        [interface_grafo.add_node(x, xlabel = f'V{x}') for x in range(linha)]

        for l in range(linha):
            for c in range(l+1, coluna):
                if self.matriz[l][c] == 1:
                    interface_grafo.add_edge(l, c)

        interface_grafo.layout(prog='dot')
        interface_grafo.write('/home/matheus/Documentos/Faculdade/5º Periodo Computacao' +
        '/Teoria dos Grafos/TrabalhoFinal/Imagens/grafo.dot')

        interface_grafo.draw('/home/matheus/Documentos/Faculdade/5º Periodo Computacao/' +
        'Teoria dos Grafos/TrabalhoFinal/Imagens/grafo.png')

        return interface_grafo