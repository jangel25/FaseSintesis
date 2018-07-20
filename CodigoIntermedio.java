
import java.util.ArrayList;

public class CodigoIntermedio {
    ArrayList<String> entrada,salida;
    int cid,cserv,cdis,csol,csen,clig;
    
    public CodigoIntermedio(ArrayList<String> e){
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
            if(entrada.get(i).equals("servo")){
                aux+="sv"+cserv+"=";
                cserv++;
                while(!(entrada.get(i).equals("(")))
                    i++;
                i++;
                while(!(entrada.get(i).equals(")"))){
                    aux+=entrada.get(i);
                    i++;
                }
                aux+=";";
                salida.add(aux);
                aux="";
            }
            if(entrada.get(i).equals("solenoid")){
                aux+="so"+csol+"=";
                csol++;
                while(!(entrada.get(i).equals("(")))
                    i++;
                i++;
                while(!(entrada.get(i).equals(")"))){
                    aux+=entrada.get(i);
                    i++;
                }
                aux+=";";
                salida.add(aux);
                aux="";
            }
            if(entrada.get(i).equals("display")){
                aux+="di"+cdis+"=";
                cdis++;
                while(!(entrada.get(i).equals("(")))
                    i++;
                i++;
                while(!(entrada.get(i).equals(")"))){
                    aux+=entrada.get(i);
                    i++;
                }
                aux+=";";
                salida.add(aux);
                aux="";
            }
            if(entrada.get(i).equals("sensor")){
                aux+="se"+csen+"=";
                csen++;
                while(!(entrada.get(i).equals("(")))
                    i++;
                i++;
                while(!(entrada.get(i).equals(")"))){
                    aux+=entrada.get(i);
                    i++;
                }
                aux+=";";
                salida.add(aux);
                aux="";
            }
            if(entrada.get(i).equals("ligth")){
                aux+="li"+clig+"=";
                clig++;
                while(!(entrada.get(i).equals("(")))
                    i++;
                i++;
                while(!(entrada.get(i).equals(")"))){
                    aux+=entrada.get(i);
                    i++;
                }
                aux+=";";
                salida.add(aux);
                aux="";
            }
            if(entrada.get(i).equals("int")||entrada.get(i).equals("text")
               ||entrada.get(i).equals("boolean")||entrada.get(i).equals("float")){
                aux+="t"+cid+"=";
                cid++;
                while(!(entrada.get(i).equals("=")))
                    i++;
                i++;
                while(!(entrada.get(i).equals("$"))){
                    aux+=entrada.get(i);
                    i++;
                }
                aux+=";";
                salida.add(aux);
                aux="";
            }
            if(entrada.get(i).equals("task")){
                reinicia();
            }
            
            
            i++;
        }     
        
    }
    
    public static void main(String[] args) {
        ArrayList<String> prueba=new ArrayList<>();
        prueba.add("task");
        prueba.add("{");
        prueba.add("int");
        prueba.add("hola");
        prueba.add("=");
        prueba.add("23");
        prueba.add("$");
        prueba.add("text");
        prueba.add("hola");
        prueba.add("=");
        prueba.add("23");
        prueba.add("$");
        prueba.add("}");
        prueba.add("task");
        prueba.add("{");
        prueba.add("servo");
        prueba.add("(");
        prueba.add("8");
        prueba.add(")");
        prueba.add("$");
        prueba.add("}");
        prueba.add("task");
        prueba.add("{");
        prueba.add("servo");
        prueba.add("(");
        prueba.add("8");
        prueba.add(")");
        prueba.add("$");
        prueba.add("}");
        prueba.add("task");
        prueba.add("{");
        prueba.add("solenoid");
        prueba.add("(");
        prueba.add("14");
        prueba.add(")");
        prueba.add("$");
        prueba.add("solenoid");
        prueba.add("(");
        prueba.add("80");
        prueba.add(")");
        prueba.add("$");
        prueba.add("}");
        CodigoIntermedio ci=new CodigoIntermedio(prueba);
        ci.genCod();
        ci.imprime();
    }
}
