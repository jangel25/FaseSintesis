
import java.util.ArrayList;

public class CodigoIntermedio {
    ArrayList<String> salida;
    ArrayList<Token> entrada;
    int cid,cserv,cdis,csol,csen,clig;
    
    public CodigoIntermedio(ArrayList<Token> e){
        this.entrada=e;
        this.salida=new ArrayList<>();
    }
    
    public void reinicia(){
        cid=cserv=cdis=csol=csen=clig=1;
    }
    public void imprime(){
        for(int i=0;i<salida.size();i++){
            System.out.println(salida.get(i));
        }
    }
    
    public void genCod(){
        int i=0;
        reinicia();
        String aux="";
        
        while(i<entrada.size()){
            if(entrada.get(i).valor.equals("task")){
                while(!(entrada.get(i).valor.equals("{"))){
                    aux+=entrada.get(i).valor+" ";
                    i++;
                }
                salida.add(aux);
                aux="";
            }
            if(entrada.get(i).valor.equals("servo")){
                aux+="sv"+cserv+"=";
                cserv++;
                while(!(entrada.get(i).valor.equals("(")))
                    i++;
                i++;
                while(!(entrada.get(i).valor.equals(")"))){
                    aux+=entrada.get(i).valor;
                    i++;
                }
                aux+=";";
                salida.add(aux);
                aux="";
            }
            if(entrada.get(i).valor.equals("solenoid")){
                aux+="so"+csol+"=";
                csol++;
                while(!(entrada.get(i).valor.equals("(")))
                    i++;
                i++;
                while(!(entrada.get(i).valor.equals(")"))){
                    aux+=entrada.get(i).valor;
                    i++;
                }
                aux+=";";
                salida.add(aux);
                aux="";
            }
            if(entrada.get(i).valor.equals("display")){
                aux+="di"+cdis+"=";
                cdis++;
                while(!(entrada.get(i).valor.equals("(")))
                    i++;
                i++;
                while(!(entrada.get(i).valor.equals(")"))){
                    aux+=entrada.get(i).valor;
                    i++;
                }
                aux+=";";
                salida.add(aux);
                aux="";
            }
            if(entrada.get(i).valor.equals("sensor")){
                aux+="se"+csen+"=";
                csen++;
                while(!(entrada.get(i).valor.equals("(")))
                    i++;
                i++;
                while(!(entrada.get(i).valor.equals(")"))){
                    aux+=entrada.get(i).valor;
                    i++;
                }
                aux+=";";
                salida.add(aux);
                aux="";
            }
            if(entrada.get(i).valor.equals("ligth")){
                aux+="li"+clig+"=";
                clig++;
                while(!(entrada.get(i).valor.equals("(")))
                    i++;
                i++;
                while(!(entrada.get(i).valor.equals(")"))){
                    aux+=entrada.get(i).valor;
                    i++;
                }
                aux+=";";
                salida.add(aux);
                aux="";
            }
            if(entrada.get(i).valor.equals("int")||entrada.get(i).valor.equals("text")
               ||entrada.get(i).valor.equals("boolean")||entrada.get(i).valor.equals("float")){
                aux+="t"+cid+"=";
                cid++;
                while(!(entrada.get(i).valor.equals("=")))
                    i++;
                i++;
                while(!(entrada.get(i).valor.equals("$"))){
                    aux+=entrada.get(i).valor;
                    i++;
                }
                aux+=";";
                salida.add(aux);
                aux="";
                }                     
            i++;
        }
    }
    
    public static void main(String[] args) {
        ArrayList<Token> prueba=new ArrayList<>();
        prueba.add(new Token("task",1));
        prueba.add(new Token("params",1));
        prueba.add(new Token("none",1));
        prueba.add(new Token("{",1));
        prueba.add(new Token("servo",2));
        prueba.add(new Token("(",2));
        prueba.add(new Token("5",2));
        prueba.add(new Token(")",2));
        prueba.add(new Token("$",2));
        prueba.add(new Token("}",3));
        prueba.add(new Token("task",1));
        prueba.add(new Token("params",1));
        prueba.add(new Token("none",1));
        prueba.add(new Token("{",1));
        prueba.add(new Token("servo",2));
        prueba.add(new Token("(",2));
        prueba.add(new Token("5",2));
        prueba.add(new Token(")",2));
        prueba.add(new Token("$",2));
        prueba.add(new Token("}",3));
        CodigoIntermedio ci=new CodigoIntermedio(prueba);
        ci.genCod();
        ci.imprime();
    }
}
