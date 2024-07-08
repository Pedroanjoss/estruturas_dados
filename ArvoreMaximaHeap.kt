public class ArvoreMaximaHeap(private val tamanho: Int = 10): Amontoavel {

    private var dados = LongArray(tamanho)
    private var ponteiroFim = -1


    override fun inserir(dado: Long){
        if (!estaCheia()){
            ponteiroFim = ponteiroFim.inc()
            dados[ponteiroFim = dado]
            ajustarAcima(ponteiroFim)
        }else{
            println("Cheio")
        }
    }

    override fun extrair(): Long?{
        var dadoRaiz: Long? = null
        if (!estaVazia()){
            dadoRaiz = dados[0]
            dados[0] = dados[ponteiroFim]
            ponteiroFim = ponteiroFim.dec()
            ajustarAbaixo(0)
        }else{
            println("heap vazio")
        }
        return dadoRaiz
    }

    override fun atualizar(dado: Long){
        if (!estaVazia){
            dados[0] = dado
            ajustarAbaixo(0)
        }else{
            print("Heap Vazio")
        }
    }

    override fun obter(): Long?{
        var dadoRaiz: Long? = null
        if (!estaVazia()){
            dadoRaiz = dados[0]
        }else{
            print("Heap Vazio")
        }


        return dadoRaiz

    }

    private fun ajustarAcima(indice:Int){
        var indiceAtual = indice
        while (indiceAtual != 0){
            val indicePai = indicePai(indiceAtual)
            if (dados[indicePai]<dados[indiceAtual]){
                trocar(indiceAtual, indicePai)
                indiceAtual = indicePai
        }else{
            break

            }        }
    }

    private fun ajustarAbaixo(pai: Int){
        var indiceAtual = indiceFilhoEsquerda(pai)
        val filhoDireito = indiceFilhoDireita(pai)
        var maior = pai

        if (filhoEsquerdo <= ponteiroFim)
            if (dados[maior]<dados[filhoEsquerdo])
                maior = filhoEsquerdo

        if (filhoDireito<= ponteiroFim)
            if (dados[maior] < dados[filhoDireito])
                maior = filhoDireito

        if (maior != pai){
            trocar(pai, maior)
            ajustarAbaixo(maior)
        }

    }

    private fun trocar(i: Int, j:Int){
        val temp = dados[i]
        dados[i]= dados[j]
        dados[j] = temp
    }

    private fun indicePai(indiceFilho: Int): Int{
        return (indiceFilho-1)/2
    }

    private fun indiceFilhoEsquerda(indicePai: Int): Int{
        return 2 * indicePai +1
    }

    private fun indiceFilhoDireita(indicePai: Int): Int{
        return (2 *indicePai+ 1) +1
    }

    override fun estaCheia(): Boolean{
        return ponteiroFim == dados.size - 1
    }

    override fun estaVazia(): Boolean{
        return ponteiroFim == -1
    }

    override fun imprimir(): String{
        var resultado = "["
        for (i in 0..ponteiroFim){
            resultado += "${dados[i]}"
            if (i != ponteiroFim)
                resultado +=","
        }
        return "$resultado]"
    }
}
