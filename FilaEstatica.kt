interface Enfileiravel {
    
    fun enfileirar(dado: Any)
    fun desenfileirar(): Any?
    fun espiar(): Any?
    fun atualizar (dado: Any?)
    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
    fun Imprimir(): String
    
    
}

class FilaEstatica(val tamanho: Int = 10):Enfileiravel{
    //variaveis de instancia
    //os construtores vem embutidos na classe. Construtores vem implicitos
    
    private var ponteiroInicio = 0
    private var ponteiroFim = -1
    private var dados: Array<Any?> = arrayOfNulls(tamanho)
    
    //metodos auxiliares
    override fun estaCheio(): Boolean = {
        return (ponteiroFim == dados.size - 1)
    }
    
    override fun estaVazia(): Boolean = {
        return (ponteiroFim + 1 == ponteiroInicio)
    }
    
    override fun imprimir (){
        var resultado = "["
        for (i in ponteiroInicio .. ponteiro){
            if (i= ponteiroFim)
            resultado += "${dados[i]}"
            else
            resultado += "${dados[i]},"
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
        }
        else{
            println("Fila esta cheia")
        }
        
        return dado
    }
     
    override fun enfileirar(dado: Any?){
        
        if(!estaCheia()){
        ponteiroFim++
        dados[ponteiroFim] = dado
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
