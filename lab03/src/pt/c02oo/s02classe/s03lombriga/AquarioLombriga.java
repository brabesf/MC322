package pt.c02oo.s02classe.s03lombriga;

public class AquarioLombriga{
    int sizeAq;
    int sizeLo;
    int headPos;
    int toLeft;
   
    AquarioLombriga(int sizeAq, int sizeLo, int headPos){
        this.sizeAq = sizeAq;
        this.sizeLo = sizeLo;
        this.headPos = headPos;
        this.toLeft = 1;
    }
   
    public void crescer(){
        if(toLeft == 1){
            if(sizeAq < (sizeLo + headPos)){
   
                return;
            }else{
                sizeLo++;
                return;
            }
        }else{
            if((headPos - sizeLo) <= 0){
            	return;
            }else{
            
                sizeLo++;
                return;
            }
        }
    }
   
    public void virar(){
        if(toLeft == 1){
            headPos = sizeLo + headPos - 1;
            toLeft = 0;
            return;
        }
            toLeft = 1;
            headPos = (headPos - sizeLo + 1);
            return;
    }
   
   
    public void mover(){
        //substituir blocos de virar por virar()
        if(toLeft == 1){
            if(headPos == 1){
                toLeft = 0;
                headPos = sizeLo;
                return;
            }
            headPos--;
            return;
        }
        if(headPos == sizeAq){
            toLeft = 1;
            headPos = (sizeAq - sizeLo + 1);
            return;
        }
        headPos++;
        return;  
    }
   
    public String apresentar(){
        String aquario = new String();
        if(toLeft == 1){
            for(int scanPos = 1; scanPos <= sizeAq; scanPos++){
                if(scanPos == headPos){
                    aquario = aquario + "O";
                }else if(scanPos > headPos && scanPos - headPos < sizeLo){
                    aquario = aquario + "@";
                }else{
                    aquario = aquario + "#";
                }
            }
        }else{
        	for(int scanPos = 1; scanPos <= sizeAq; scanPos++){
                if(scanPos == headPos){
                    aquario = aquario + "O";
                }else if(scanPos < headPos && headPos - scanPos < sizeLo){
                    aquario = aquario + "@";
                }else{
                    aquario = aquario + "#";
                }
            }
        }
        return aquario;
    }
   
}