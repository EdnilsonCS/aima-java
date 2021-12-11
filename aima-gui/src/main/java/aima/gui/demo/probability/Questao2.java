
package aima.gui.demo.probability;

import aima.core.probability.FiniteProbabilityModel;
import aima.core.probability.bayes.approx.BayesInferenceApproxAdapter;
import aima.core.probability.bayes.approx.GibbsAsk;
import aima.core.probability.bayes.model.FiniteBayesModel;
import aima.core.probability.example.BayesNetExampleFactory;
import aima.core.probability.example.ExercicioFinalRV;
import aima.core.probability.proposition.AssignmentProposition;

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


    public static void demoBayesGibbsRendaFamiliarIgualA3SalariosMinimos(FiniteProbabilityModel model){
      System.out.println("P<>(LIKES = true | American AND younger between 31-40 AND watch tv = some)");
      
      	
  
      AssignmentProposition ensino = new AssignmentProposition(
        ExercicioFinalRV.SEGUNDO_GRAU_RV, "publico");
  
      
      System.out.println("P<>(LIKES = true | American AND younger between 31-40 AND watch tv = some) = "
              + model.priorDistribution(ExercicioFinalRV.BOLSA_RV,
              ensino ));        
	};
  
}