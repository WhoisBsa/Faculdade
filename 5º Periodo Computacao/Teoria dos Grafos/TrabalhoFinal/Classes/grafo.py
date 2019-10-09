#! python3
# coding: utf-8

from random import randint


class Grafo:
    def __init__(self):
        self.vertices = []
        self.matriz = [[0]*0 for i in range(0)]
        self.predecessor = [None] * 0

    
    def mostra_dados(self):
        """Mostra o grafo na tela."""
        linha = coluna = len(self.matriz)
        print()
        for l in range(linha):
            for c in range(coluna):
                print(self.matriz[l][c], end='\t')
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
            for c in range(coluna):
                if l != c and self.matriz[l][c] == 0:
                    return False
        return True


    def complementar(self):
        """Cria o grafo complementar da matriz"""
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


    def checa_arvore(self):
        self.busca_largura(0)
        contNONE = 0
        for i in self.predecessor:
            if i == None:
                contNONE += 1
            if contNONE > 1:
                return False
        
        return True


    def busca_largura(self, indice):
        if not(self.existe_vertice(indice)):
            return False

        linha = len(self.matriz)

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
            for v, i in enumerate(self.matriz[u]):
                if i == 1:
                    if cor[v] in 'BRANCO':
                        cor[v] = 'CINZA'
                        distancia[v] = distancia[u] + 1
                        self.predecessor[v] = u
                        fila.append(v)
            
            cor[indice] = 'PRETO'
        
        print('\n\tPredecessores:\n')
        for i in range(linha):
            print(f'\tV{i}', end='')
        print()
        for pi in self.predecessor:
            print(f'\t{pi}', end='')
        print('\n')
        return True


    def busca_profundidade(self, indice):
        if not(self.existe_vertice(indice)):
            return False
        
        linha = len(self.matriz)
        result = [{'predecessor': None, 'time1': 999, 'time2': 999}] * linha

        cor = ['BRANCO'] * linha
        self.predecessor = [None] * linha
        time = 0
        for i in range(linha):
            if cor[i] in 'BRANCO':
                result[i] = self.busca_profundidade_visit(i)
        print(result)
        return True


    def busca_profundidade_visit(self, u):
        linha = len(self.matriz)
        cor = ['BRANCO'] * linha
        self.predecessor = [None] * linha
        time = 0
        
        cor[u] = 'CINZA'
        time += 1
        time1 = time
        for v, i in enumerate(self.matriz[u]):
            if i == 1:
                if cor[v] in 'BRANCO':
                    self.predecessor[v] = u
                    self.busca_profundidade_visit(v)
        cor[u] = 'PRETO'
        time += 1
        time2 = time
        return self.predecessor, time1, time2


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
