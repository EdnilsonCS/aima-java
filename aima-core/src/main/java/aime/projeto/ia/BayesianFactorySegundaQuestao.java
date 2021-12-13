package aime.projeto.ia;

import aima.core.probability.bayes.BayesianNetwork;
import aima.core.probability.bayes.FiniteNode;
import aima.core.probability.bayes.impl.BayesNet;
import aima.core.probability.bayes.impl.FullCPTNode;
import aima.core.probability.example.ExercicioFinalRV;

public class BayesianFactorySegundaQuestao {
	public static BayesianNetwork constructBolsaNetwork(){
		FiniteNode bolsa = new FullCPTNode(ExercicioFinalRV.BOLSA_RV, new double[] {
			0.1111, 
			0.1111,
			0.1111,
			0.1111,
			0.1111,
			0.1111, 
			0.1111,
			0.1111,
			0.1112
		});	
		
		@SuppressWarnings("unused")
		FiniteNode rendaFamiliar = new FullCPTNode(ExercicioFinalRV.RENDA_FAMILIAR_RV,
		new double[] {
			0.01,
			0.29,
			0.70,
			0.03,
			0.32,
			0.65,
			0.15,
			0.45,
			0.40,
			0.20,
			0.50,
			0.30,
			0.35,
			0.40,
			0.25,
			0.52,
			0.33,
			0.15,
			0.65,
			0.25,
			0.10,
			0.75,
			0.23,
			0.02,
			0.80,
			0.19,
			0.01
		},bolsa);


		@SuppressWarnings("unused")
		FiniteNode trabalha = new FullCPTNode(ExercicioFinalRV.TRABALHA_RV,
		new double[] {
			0.50, 
			0.50, 

			0.55, 
			0.45,

			0.60, 
			0.40, 

			0.65, 
			0.35, 

			0.70, 
			0.30, 

			0.75, 
			0.25, 

			0.75, 
			0.25,

			0.75, 
			0.25, 

			0.75,
			0.25,
		},bolsa);


		@SuppressWarnings("unused")
		FiniteNode conjuge = new FullCPTNode(ExercicioFinalRV.CONJUGE_RV,
		new double[] {
			0.50, 
			0.50, 
			0.50, 
			0.50, 
			0.55, 
			0.45, 
			0.60, 
			0.40, 
			0.62, 
			0.38, 
			0.64, 
			0.36, 
			0.66, 
			0.34,
			0.68, 
			0.32, 
			0.70,
			0.30,
		},bolsa);

		@SuppressWarnings("unused")
		FiniteNode irmao = new FullCPTNode(ExercicioFinalRV.IRMAO_RV,
		new double[] {
			0.50, 
			0.50, 
			0.55, 
			0.45, 
			0.60,
			0.40, 
			0.62, 
			0.38, 
			0.64,
			0.36, 
			0.66, 
			0.34, 
			0.68, 
			0.32, 
			0.69, 
			0.31,
			0.70,
			0.30,
		},bolsa);

		@SuppressWarnings("unused")
		FiniteNode reside = new FullCPTNode(ExercicioFinalRV.RESIDE_RV,
		new double[] {
			0.70, 
			0.30, 
			0.65, 
			0.35, 
			0.60, 
			0.40, 
			0.55, 
			0.45, 
			0.50, 
			0.50, 
			0.45, 
			0.55,
			0.40,
			0.60, 
			0.20, 
			0.80, 
			0.10,
			0.90,
					
		},bolsa);

		@SuppressWarnings("unused")
		FiniteNode imovel = new FullCPTNode(ExercicioFinalRV.IMOVEL_RV,
		new double[] {
			 0.70, 
			 0.30, 
			 0.65, 
			 0.35, 
			 0.60, 
			 0.40, 
			 0.55, 
			 0.45, 
			 0.50, 
			 0.50,
			 0.45, 
			 0.55, 
			 0.40,
			 0.60, 
			 0.20, 
			 0.80, 
			 0.10,
			 0.90,
			
		},bolsa);


		@SuppressWarnings("unused")
		FiniteNode doenca = new FullCPTNode(ExercicioFinalRV.DOENCA_GRAVE_RV,
		new double[] {
			0.40, 
			0.60, 
			0.45,
			0.55, 
			0.50, 
			0.50, 
			0.55,
			0.45, 
			0.60, 
			0.40, 
			0.65, 
			0.35, 
			0.70, 
			0.30, 
			0.75, 
			0.25, 
			0.80,
			0.20,
		},bolsa);

		@SuppressWarnings("unused")
		FiniteNode faseEstuda = new FullCPTNode(ExercicioFinalRV.FASE_RV,
		new double[] {
			0.54,
			0.36,
			0.10,

			0.56,
			0.35,
			0.09,

			0.58,
			0.34,
			0.08,

			0.60,
			0.33,
			0.07,

			0.62,
			0.32,
			0.06,

			0.64,
			0.31,
			0.05,

			0.66,
			0.30,
			0.04,

			0.68,
			0.29,
			0.03,
			
			0.70,
			0.28,
			0.02
		},bolsa);

		@SuppressWarnings("unused")
		FiniteNode segundoGRAU = new FullCPTNode(ExercicioFinalRV.SEGUNDO_GRAU_RV,
		new double[] {
				0.10,
				0.90,
				0.13,
				0.87,
				0.25,
				0.75,
				0.55,
				0.45,
				0.60,
				0.40,
				0.65,
				0.35,
				0.70,
				0.30,
				0.80,
				0.20,
				0.90,
				0.10
		},bolsa);
		return new BayesNet(bolsa);
	}

}
