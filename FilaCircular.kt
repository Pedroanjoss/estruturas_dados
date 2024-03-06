interface Enfileiravel {
    
    fun enfileirar(dado: Any)
    fun desenfileirar(): Any?
    fun espiar(): Any?
    fun atualizar (dado: Any?)
    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
    fun Imprimir(): String
    
    
}

class FilaEstaticaCircular(val tamanho: Int = 10):Enfileiravel{
    //variaveis de instancia
    //os construtores vem embutidos na classe. Construtores vem implicitos
    
    private var ponteiroInicio = 0
    private var ponteiroFim = -1
    private var dados: Array<Any?> = arrayOfNulls(tamanho)
    private var quantidade = 0
    
    //metodos auxiliares
    override fun estaCheio(): Boolean = {
        return (quantidade == dados.size )
    }
    
    override fun estaVazia(): Boolean = {
        return (quantidade == 0)
    }
    
    override fun imprimir (){
        var resultado = "["
        var aux = ponteiroInicio
        for (i in 0..quantidade){
			if (i=quantidade)
            resultado += "${dados[aux]}"
            aux++
             
            else
            resultado += "${dados[aux]},"
            aux++
             if(aux == dados.size)
                 aux=0
        }
        
        return "$resultado]"
        
    }
    //metodos principais
    override fun espiar() : Any?{
        var dado: Any? = null
        if(!estaVazia){
            dado = dados[ponteiroInicio]
        }
        else{
            println("Fila esta vazia")
        }
        
        return dado
    }
    
    
     override fun desenfileirar() : Any?{
        var dado: Any? = null
        if(!estaVazia()){
            dado = dados[ponteiroInicio]
            ponteiroInicio++
            
            if(ponteiroInico == dados.size)
           	   ponteiroInicio = 0
            
            quantidade--
        }
        else{
            println("Fila esta cheia")
        }
        
        return dado
    }
     
    override fun enfileirar(dado: Any?){
        
        if(!estaCheia()){
        ponteiroFim++
        
            
             if(ponteiroFim == dados.size)
           	   ponteiroFim == 0
            
        dados[ponteiroFim] = dado
        quantidade++
        }
        
        else{
            println("Fila esta cheia")
        }
    }
    
    override atualizar(novoDado:Any?){
        if(!estaVazia())
           dados[ponteiroInicio]= novoDado
        else{
             println("Fila esta vazia")
        }
    }
    
    
}
