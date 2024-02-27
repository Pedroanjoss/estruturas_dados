
interface Empilhavel {
    // Metodos principais
    fun empilhar(dado: Any?)
    fun desempilhar(): Any?
    fun topo(): Any?
    // Metodos auxiliares
    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
    fun imprimir(): String
}

class PilhaEstatica : Empilhavel {
    //variaveis globais(instancia)
    private var ponteiroTopo: Int
    private var dados: Array:<Any?>
    //construtores
    constructor() : this(10)
    
    constructor(tamanho: Int){
        ponteiroTopo = -1,
        dados =  arrayofNulls(tamanho) 
    }
    //metodos auxiliares
    override fun estaCheia(): Boolean{
        return (ponteiroTopo == dados.size -1)
    }
    override fun estaVazia(): Boolean{
        return(ponteiroTopo == -1)
    }
    override fun imprimir(): String{
        var resultado = "["
        //iterar pilha
        for (i in ponteiroTopo downTo 0){
            if (i == 0)
             resultado += "${dados[i]}"
            else
             resultado += "${dados[i]},"
        }
        return "$resultado]"
    }
    
    //metodos principais
    override fun empilhar(dado: Any?){
        if (!estaCheia()){
            ponteiroTopo++
            dados[ponteiroTopo] = dado
        }
        else{
            println("Stack is full")
        }
    }
    override fun desempilhar(): Any?{
        var retorno: Any = null
        if(!estaVazia()){
            retorno = dados[ponteiroTopo]
            ponteiroTopo--
        }
        else{
            println("Stack is empty")
        }
        
        
    }
    override fun topo(): Any?{
        var retorno: Any? = null
        
        if(!estaVazia()){
            retorno =  dados[ponteiroTopo]
        }
         else{
            println("Stack is empty")
        }
        
        return retorno
    }
}
