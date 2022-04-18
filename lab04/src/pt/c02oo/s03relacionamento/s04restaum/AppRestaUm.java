package pt.c02oo.s03relacionamento.s04restaum;

public class AppRestaUm {

   public static void main(String[] args) {
      AppRestaUm.executaJogo(null, null);
   }
   
   public static void executaJogo(String arquivoEntrada, String arquivoSaida) {
      Toolkit tk = Toolkit.start(arquivoEntrada, arquivoSaida);
      
      Tabuleiro jogo = new Tabuleiro();
      jogo.criaTabuleiro();
      String commands[] = tk.retrieveCommands();
      char sequencia[][][] = new char[commands.length][60][60];
      System.out.println("=== Entrada");
      for (int l = 0; l < commands.length; l++)
         System.out.println(commands[l]);
      
      System.out.println("=== Primeira Saída");
      char board[][] = {
         {' ', ' ', 'P', 'P', 'P', ' ', ' '},
         {' ', ' ', 'P', 'P', 'P', ' ', ' '},
         {'P', 'P', 'P', 'P', 'P', 'P', 'P'},
         {'P', 'P', 'P', '-', 'P', 'P', 'P'},
         {'P', 'P', 'P', 'P', 'P', 'P', 'P'},
         {' ', ' ', 'P', 'P', 'P', ' ', ' '},
         {' ', ' ', 'P', 'P', 'P', ' ', ' '}
      };
            
      tk.writeBoard("Tabuleiro inicial", board);
      
      for(int i = 0; i<commands.length; i++) {
    	  sequencia[i] = jogo.movimento(commands[i]);
    	  char[] move = new char[commands[i].length()];
		   
    	  for(int j = 0; j<commands[i].length(); j++) {
			   move[j] = commands[i].charAt(j);
		  }
    	  tk.writeBoard("source: " + String.copyValueOf(move, 0, 2) + "; target: " + String.copyValueOf(move, 3, 2), sequencia[i]);
      }
      
      tk.stop();
   }

}
