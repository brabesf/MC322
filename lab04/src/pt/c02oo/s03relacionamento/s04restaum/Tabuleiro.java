package pt.c02oo.s03relacionamento.s04restaum;

public class Tabuleiro {
    
    
    private Peca jogo[][] = new Peca[7][7]; 
    private Peca teste;
    
    Tabuleiro(){
        this.jogo = new Peca[7][7]; 
        this.teste = new Peca();
    }
    
    public void criaTabuleiro() {
    	teste.associaTabuleiro(this);
    	teste.espacoInvalido();
    	System.out.println(teste.getExiste());
    	System.out.println('c'-'a');
	    for(int i = 0; i<7; i++){
	        for(int j = 0; j<7; j++){
	        	jogo[i][j] = new Peca();
	        	jogo[i][j].associaTabuleiro(this);
	            if((i<2 && j<2) || (i>4 && j>4) || (j<2 && i>4) || (i<2 && j>4)){
	                jogo[i][j].espacoInvalido();
	            }else{
	                jogo[i][j].colocaPeca();
	            }
	        }
	    }
	    jogo[3][3].tiraPeca();
    }
    
    boolean temEspaco(int a, int b) {
    	if((jogo[a][b].getExiste()) == 0) {
    		return true;
    	}
    	return false;
    }
    
    boolean temPeca(int a, int b) {
    	System.out.println(a + "and " + b);
    	if((jogo[a][b].getExiste()) == 1) {
    		
    		return true;
    	}
    	return false;
    }
    
    public char[][] movimento(String comando) {
    	char saida[][] = new char[7][7];
    	System.out.println((comando.charAt(1)-'1') + "and " + (comando.charAt(0) - 'a'));
    	if(jogo[comando.charAt(1)-'1'][comando.charAt(0) - 'a'].podeMover(comando)) {
    		
    		jogo[comando.charAt(1)-'1'][comando.charAt(0)-'a'].tiraPeca(); //tira
    		
    		jogo[((comando.charAt(1) + comando.charAt(4))/2)-'1'][((comando.charAt(0)+comando.charAt(3))/2)-'a'].tiraPeca(); //come
    		jogo[comando.charAt(4)-'1'][comando.charAt(3)-'a'].colocaPeca();
    	}
    	for(int i = 0; i<7; i++) {
    		for(int j = 0; j<7; j++) {
    			if((jogo[i][j].getExiste()) == 1) {
    				saida[i][j] = 'P';
    				
    			}else if((jogo[i][j].getExiste()) == 0) {
    				saida[i][j] = '-';
    				
    			}else {
    				saida[i][j] = ' ';
    				
    			}
    			if(i==7) {
    				saida[8][j] = '\n';
    				
    			}
    		}
    	}
    	return saida;
    	
    }
}