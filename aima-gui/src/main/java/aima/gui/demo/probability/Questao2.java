
package aima.gui.demo.probability;

import aima.core.probability.bayes.approx.BayesInferenceApproxAdapter;
import aima.core.probability.bayes.approx.GibbsAsk;
import aima.core.probability.bayes.model.FiniteBayesModel;
import aima.core.probability.example.BayesNetExampleFactory;

public class Questao2 {
  public static final int NUM_SAMPLES = 10000000; 


  public static void main(String[] args) {
    System.out.println("-------------------QUESTÃO 2 LETRA A-----------------");

    bayesGibbsRendaFamiliarIgualA3SalariosMinimos();
   // bayesGibbsGanharBolsaSendoEstudanteDoEnsinoMedioEscolaPublica()
  }

  public static void bayesGibbsRendaFamiliarIgualA3SalariosMinimos(){

		System.out.println("DEMO: Probabilidade da Renda Familiar ser de um a três salários mínimos: TV N = " + NUM_SAMPLES);
		System.out.println("=====================GIBBS===================");
    demoBayesGibbsRendaFamiliarIgualA3SalariosMinimos(
			new FiniteBayesModel(
				BayesNetExampleFactory.constructBolsaNetwork(),
				new BayesInferenceApproxAdapter(new GibbsAsk(), NUM_SAMPLES))
		);
	}


  
}