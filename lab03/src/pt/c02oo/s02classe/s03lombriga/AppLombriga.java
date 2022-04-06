package pt.c02oo.s02classe.s03lombriga;

public class AppLombriga {

   public static void main(String[] args) {
      Toolkit tk = Toolkit.start();
      Animacao animacao = new Animacao();
      
      
      
      String lombrigas[] = tk.recuperaLombrigas();
      
      for (int l = 0; l < (lombrigas.length); l++) {
    	 String cenas[] = new String[lombrigas[l].length()-6];
         cenas = animacao.executaAnimacao(lombrigas[l]);
         tk.gravaPasso("=====");
         for(int i = 0; i<cenas.length; i++) {
        	 tk.gravaPasso(cenas[i]);
         }
      }
      /*tk.gravaPasso("=====");
      tk.gravaPasso("##O@@@##");
      tk.gravaPasso("#O@@@###");
      tk.gravaPasso("#O@@@@##");
      tk.gravaPasso("O@@@@###");
      tk.gravaPasso("@@@@O###");
      tk.gravaPasso("#@@@@O##");
      */
      tk.stop();
   }

}
