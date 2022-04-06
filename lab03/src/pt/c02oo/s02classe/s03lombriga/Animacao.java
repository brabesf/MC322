package pt.c02oo.s02classe.s03lombriga;

public class Animacao {

	public String[] executaAnimacao(String animacao) {
		   int aq;
		   int lo;
		   int hp;
		   int size = animacao.length();
		   char[] anim = new char[size];
		   String[] conjunto = new String[size-5];
		   for(int i = 0; i<size; i++) {
			   anim[i] = animacao.charAt(i);
		   }
		   aq = Integer.valueOf(String.copyValueOf(anim, 0, 2));
		   lo = Integer.valueOf(String.copyValueOf(anim, 2, 2));
		   hp = Integer.valueOf(String.copyValueOf(anim, 4, 2));
		   AquarioLombriga scene = new AquarioLombriga(aq, lo, hp);
		   for(int i = 6; i<size; i++) {
			   conjunto[i-6] = scene.apresentar();
			   if(anim[i] == 'C') {
				   scene.crescer();
			   }else if(anim[i] == 'M') {
				   scene.mover();
			   }else {
				   scene.virar();
			   }
		   }
		   conjunto[size-6] = scene.apresentar();
		   return conjunto;
	   }
}
