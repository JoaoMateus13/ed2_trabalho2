package Tree;

import org.testng.annotations.Test;

public class RBTree<Key extends Comparable<Key>, Value>
{	
	
	protected static final boolean RED = true;
    protected static final boolean BLACK = false;

    protected class Node {
        public Key chave;
        public Value valor;
        public Node esq, dir;

        boolean cor;
        int size;

        Node(Key key, Value value, int size, boolean color) {
            this.chave = key;
            this.valor = value;

            this.size = size;
            this.cor = color;
        }
    }

    protected Node raiz;



	private boolean isRed(Node no) {
		if(no==null) return false;
		return (no.cor == RED); //se no for preto, retorna false
	}
	
	private boolean isBlack(Node no) {
		if (no == null) return true;
		return (no.cor == BLACK);
	}
	
	 public int size() {
        return size(raiz);
    }

    protected int size(Node no) {
        if (no == null) {
            return 0;
        }

        return no.size;
    }

    public boolean isEmpty() {
        return size(raiz) == 0;
    }



	 protected Node rotacaoEsquerda(Node no) {
        if (no == null || no.dir == null) {
            return no;
        }
		 Node novaRaiz = no.dir;

		 no.dir = novaRaiz.esq;
		 novaRaiz.esq = no;

		 novaRaiz.cor = novaRaiz.esq.cor;
		 novaRaiz.esq.cor = RED;

		 novaRaiz.size = no.size;
		 no.size = size(no.esq) + 1 + size(no.dir);
        return novaRaiz;
    }

	private Node rotacaoDireita(Node no) {
		if (no == null || no.esq == null) {
			return no;
		}

		Node novaRaiz = no.esq;

		no.esq = novaRaiz.dir;
		novaRaiz.dir = no;

		novaRaiz.cor = novaRaiz.dir.cor;
		novaRaiz.dir.cor = RED;

		novaRaiz.size = no.size;
		no.size = size(no.esq) + 1 + size(no.dir);

		return novaRaiz;
	}

	private void trocaCor(Node no) {
		if (no==null) return;
		no.cor = !no.cor;
		no.dir.cor = !no.dir.cor;
		no.esq.cor = !no.esq.cor;
	}


	private Node balance(Node no){
		if (isRed(no.dir) && !isRed(no.esq))
			no = rotacaoEsquerda(no);

		if (isRed(no.esq) && isRed(no.esq.esq))
			no = rotacaoDireita(no);

		if (isRed(no.esq) && isRed(no.dir))
			trocaCor(no);

		no.size = size(no.esq) + size(no.dir) + 1;
		return no;
	}



	public void insere(Key key, Value val){
		if (key == null) throw new IllegalArgumentException("first argument to put() is null");
		raiz = insere(raiz, key, val);
		raiz.cor = BLACK;
	}
	
	private Node insere(Node no, Key key, Value val)
	{
		if (no == null) // Do standard insert, witno red link to parent.
			return new Node(key, val, 1, RED);
		
		int cmp = key.compareTo(no.chave);
		if (cmp < 0) 
			no.esq = insere(no.esq, key, val);
		else if (cmp > 0) 
			no.dir = insere(no.dir, key, val);
		else no.valor = val;
		
		if (isRed(no.dir) && !isRed(no.esq))
			no = rotacaoEsquerda(no);

		if (isRed(no.esq) && isRed(no.esq.esq))
			no = rotacaoDireita(no);

		if (isRed(no.esq) && isRed(no.dir))
			trocaCor(no);
		
		no.size = size(no.esq) + size(no.dir) + 1;
		return no;
	}

	public int altura() {
		return altura(raiz);
	}
	private int altura(Node no) {
		if (no == null) return -1;
		return 1 + Math.max(altura(no.esq), altura(no.dir));
	}

	public void view() {
		view(raiz);
	}

	// Caminha na árvore em pré-ordem e imprime cada elemento
	private void view(Node no) {
		if(no == null) return;
		System.out.println(no.valor.toString());
		view(no.esq);
		view(no.dir);
	}

}
