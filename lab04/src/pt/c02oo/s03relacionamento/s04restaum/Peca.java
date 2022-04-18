package pt.c02oo.s03relacionamento.s04restaum;


public class Peca{
    
    private int existe; 
    private Tabuleiro tabuleiro;
    
    Peca(){
    	this.existe = 0;
    	this.tabuleiro = null;
    }

    Peca(int existe){
        this.existe = existe;
    }
    
    int getExiste() {
    	return existe;
    }

    void espacoInvalido(){
        this.existe = -1;
    }

    void colocaPeca(){
        this.existe = 1;
    }

    void tiraPeca(){
        this.existe = 0;
    }

    void associaTabuleiro(Tabuleiro jogo){
        this.tabuleiro = jogo;
    }
    
    boolean podeMover(String comando) {
    	if((comando.charAt(3) - 'a')>6) {
    		System.out.println("one");
    		return false;
    	}else if((comando.charAt(1)-comando.charAt(4))!= 0){
    		if((comando.charAt(0)-comando.charAt(3))!= 0) {
    			System.out.println("tw");
    			return false;
    		}else if((comando.charAt(1)-comando.charAt(4))*(comando.charAt(1)-comando.charAt(4))!=4){
    			System.out.println("thr");
    			return false;
    		}
    	}
    	if((comando.charAt(0)-comando.charAt(3))*(comando.charAt(0)-comando.charAt(3))!=4) {
    		System.out.println("fo");
    		return false;
    	}
    	if(tabuleiro.temPeca((((comando.charAt(1) + comando.charAt(4))/2)-'1'), ((comando.charAt(0)+comando.charAt(3))/2)-'a')) {
    		System.out.println("fsex");
    		if(tabuleiro.temEspaco(comando.charAt(4)-'1' , comando.charAt(3)-'a')) {
    			System.out.println("the teime has come");
    			return true;
    		}
    	}
    	System.out.println("fa");
    	return false;
    }
}