package pt.c02oo.s02classe.s03lombriga;

public class AppLombriga {
	
   public void executaAnimacao(String animacao) {
	   int aq;
	   int lo;
	   int hp;
	   int size = animacao.length();
	   char[] anim = new char[size];
	   for(int i = 0; i<size; i++) {
		   anim[i] = animacao.charAt(i);
	   }
	   aq = Integer.valueOf(String.copyValueOf(anim, 0, 2));
	   lo = Integer.valueOf(String.copyValueOf(anim, 2, 4));
	   hp = Integer.valueOf(String.copyValueOf(anim, 4, 6));
	   AquarioLombriga scene = new AquarioLombriga(aq, lo, hp);
	   for(int i = 6; i<size; i++) {
		   scene.apresentar();
		   if(anim[i] == 'C') {
			   scene.crescer();
		   }else if(anim[i] == 'M') {
			   scene.mover();
		   }else {
			   scene.virar();
		   }
	   }
	   scene.apresentar();
   }

   public static void main(String[] args) {
      Toolkit tk = Toolkit.start();
      
      String lombrigas[] = tk.recuperaLombrigas();
      
      for (int l = 0; l < lombrigas.length; l++)
         System.out.println(lombrigas[l]);
      
      tk.gravaPasso("=====");
      tk.gravaPasso("##O@@@##");
      tk.gravaPasso("#O@@@###");
      tk.gravaPasso("#O@@@@##");
      tk.gravaPasso("O@@@@###");
      tk.gravaPasso("@@@@O###");
      tk.gravaPasso("#@@@@O##");
      
      tk.stop();
   }

}
