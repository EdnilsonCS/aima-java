package aima.core.probability.example;

import aima.core.probability.domain.ArbitraryTokenDomain;
import aima.core.probability.domain.BooleanDomain;
import aima.core.probability.util.RandVar;


public class ExercicioFinalRV {

	public static final RandVar AMERICAN_RV = new RandVar("American",
	 new BooleanDomain());

  public static final RandVar NON_AMERICAN_RV = new RandVar("NON_AMERICAN",
 	new BooleanDomain());

  public static final RandVar LIKES_SOCCER_RV = new RandVar("LIKES_SOCCER",
	new BooleanDomain());

  public static final RandVar AGE_RV = new RandVar("AGE",
		new ArbitraryTokenDomain("a1", "a2", "a3"));

  public static final RandVar WATCH_SOME_RV = new RandVar("WATCH",
		new ArbitraryTokenDomain("lot", "some", "none"));		

 // Questão 2

 public static final RandVar RENDA_FAMILIAR_RV =  new RandVar("RENDA", 	new ArbitraryTokenDomain("um_sm", "dois_sm", "tres_sm"));

 public static final RandVar TRABALHA_RV =  new RandVar("WORK", new BooleanDomain());
 
 public static final RandVar CONJUGE_RV =  new RandVar("CONJUGE", new BooleanDomain());

 public static final RandVar SEGUNDO_GRAU_RV =  new RandVar("SEGUNDO_GRAU", new ArbitraryTokenDomain("publico", "privado"));

 public static final RandVar BOLSA_RV = new RandVar("BOLSA",  new ArbitraryTokenDomain("dez", "quinze", "vinte", "vince_cinco", "trinta", "trinta_cinco", "quarenta", "quarenta_cinco", "cinquenta"));

 public static final RandVar IRMAO_RV = new RandVar("IRMAO", new BooleanDomain());

 public static final RandVar FASE_RV =  new RandVar("FASE", new ArbitraryTokenDomain("PRIMEIRA_QUARTA", "QUINTA_SETIMA", "ACIMA_QUINTA"));

 public static final RandVar DOENCA_GRAVE_RV =  new RandVar("DOENCA_GRAVE", new BooleanDomain());

 public static final RandVar IMOVEL_RV =  new RandVar("IMOVEL_GRAVE", new BooleanDomain());

 public static final RandVar RESIDE_RV =  new RandVar("RESIDE", new BooleanDomain());
}