#! python3
# coding: utf-8

"""
Trabalho Final - Teoria dos Grafos

Matheus Barbosa e Rafael Sidnei - 5° Período
"""


from Classes.grafo import Grafo
from Classes.menu import Menu

if __name__ == "__main__":
    grafo = Grafo()
    m = Menu()
    m.mostra_menu(grafo)
