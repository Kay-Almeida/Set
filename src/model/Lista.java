package model;

public class Lista<T> {
    
    No<T> primeiro; 
    
    public Lista() {
        primeiro = null; 
    }
    
    public boolean isEmpty() {
        return primeiro == null;
    }
    
    public int size() {
        int cont = 0; 
        if(!isEmpty()) {
            No<T> auxiliar = primeiro; 
            while(auxiliar != null) {
                cont++; 
                auxiliar = auxiliar.proximo; 
            }
        }
        return cont; 
    }
    
    private No<T> getNo(int pos) throws Exception {
        if(isEmpty()){
            throw new Exception ("Lista Vazia"); 
        }
        int tamanho = size(); 
        if(pos < 0 || pos >= tamanho) {
            throw new Exception ("Posição inválida"); 
        }
        No<T> auxiliar = primeiro; 
        int cont = 0; 
        while(cont < pos) {
            auxiliar = auxiliar.proximo; 
            cont++; 
        }
        return auxiliar; 
    }
    
    private boolean contains(T valor) {
        No<T> auxiliar = primeiro;
        while (auxiliar != null) {
            if (auxiliar.dado.equals(valor)) {
                return true;
            }
            auxiliar = auxiliar.proximo;
        }
        return false;
    }
    
    public void addFirst(T valor) throws Exception {
        if (!contains(valor)) {
            No<T> elemento = new No<T>(valor);
            elemento.proximo = primeiro; 
            primeiro = elemento;
        }
    }
    
    public void addLast(T valor) throws Exception {
        if (!contains(valor)) {
            int tamanho = size(); 
            
            if(isEmpty()) {
                throw new Exception ("Lista Vazia"); 
            }
            No<T> elemento = new No<T>(valor); 
            elemento.proximo = null; 
            
            No<T> ultimo = getNo(tamanho - 1); 
            ultimo.proximo = elemento; 
        }
    }
    
    public void add(T valor, int posicao) throws Exception {
        if (!contains(valor)) {
            if(isEmpty()) {
                throw new Exception("Lista Vazia"); 
            }
            int tamanho = size(); 
            if(posicao < 0 || posicao > tamanho) {
                throw new Exception("Posição inválida"); 
            }
            if(posicao == 0) {
                addFirst(valor);
            } else if (posicao == tamanho){
                addLast(valor);
            } else {
                No<T> elemento = new No<T>(valor); 
                No<T> anterior = getNo(posicao - 1); 
                elemento.proximo = anterior.proximo;
                anterior.proximo = elemento; 
            }
        }
    }
    
    
    public T get(int pos) throws Exception {
        if(isEmpty()) {
            throw new Exception("Lista Vazia");
        }
        int tamanho = size(); 
        if(pos < 0 || pos >= tamanho) {
            throw new Exception("Posição Inválida");
        }
        No<T> auxiliar = primeiro; 
        int cont = 0; 
        while(cont < pos) {
            auxiliar = auxiliar.proximo; 
            cont++; 
        }
        return auxiliar.dado; 
    }
}