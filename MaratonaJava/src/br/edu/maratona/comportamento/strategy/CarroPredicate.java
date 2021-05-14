package br.edu.maratona.comportamento.strategy;

import br.edu.maratona.comportamento.Carro;
@FunctionalInterface
public interface CarroPredicate 
{boolean teste(Carro carro);}