(ns firstclojure.functions-available)

(def vetor ["A" "B" "C" "D" "E"])

; Pega as 2 primeiras posições do vetor
(take 2 vetor)

; Cria um novo vetor com os campos F e G adicionados
(into vetor ["F" "G"])

; Também faz conversões de uma estrutura para outra
(into [] {:x 1 :y 2})                                       ; [[:x 1] [:y 2]]

; Itera sobre o valor de i. O recur reinicia a execução desde o loop, ou uma função anônima por exemplo.
(loop [i 0]
  (when (< i 10)
    (println "Int: " i)
    (recur (inc i))))

; Versão recursiva do loop acima
(defn iterador
  [i]
  (when (< i 10)
    (println "Int: " i)
    (iterador (inc i))))

; Adiciona o primeiro parâmetro como primeiro elemento da
(cons 1 [2 3 4])                                            ; (1 2 3 4)

;   Retorna o primeiro elemento da lista
(first [1 2 3 4])                                           ; 1

; Retorna os últimos elementos da lista, com excessão do primeiro
(rest [1 2 3 4])                                            ; (2 3 4)

;Transforma um objeto em uma sequência válida
(seq "Thiago")                                              ; (\T \h \i \a \g \o)

; itera sobre cada elemento de cada lista e os adiciona como parâmetro da função em pares.
(map inc [1 2 3 4])                                         ; (2 3 4 5)
(map str ["a" "b" "c"] ["A" "B" "C"])                       ; ("aA" "bB" "cC")
(map list ["a" "b"] ["A" "B"] [1 2])                        ; (("a" "A" 1) ("b" "B" 2))

; Filtra uma sequência de acordo com a função passada
(filter #(> 4 %) [1 2 3 4 5 6])                             ;(1 2 3)

; Reduz um vetor ou mapa a outro tipo de dado
(reduce + [1 2 3 4 5])                                      ; 15

; incrementa o valor de cada chave do mapa e retorna um novo mapa atualizado
(reduce (fn [new-map [key val]]
          (assoc new-map key (inc val)))
        {}
        {:x 1 :y 2})

; Implementação da função map utilizando reduce
(defn map' [f coll]
  (reduce (fn [vetor next]
            (conj vetor (f next))) [] coll))

; Implementação do filter com reduce
(defn filter' [f coll]
  (reduce (fn [vetor next]
            (if (f next)
              (conj vetor next)
              vetor)) [] coll))

; Associa a um vetor ou mapa o valor passado como parâmetro
(assoc [1 2] 0 5)                                           ; [5 2]
(assoc {:x 1.2 :y 1.3} :z 2.4)                              ; {:x 1.2, :y 1.3, :z 2.4}
(assoc {:x 1.2 :y 1.3} :x 2.4)                              ; {:x 2.4, :y 1.3}

; Pega os 3 primeiros itens da sequência
(take 3 [1 2 3 4 5 6])                                      ; (1 2 3)
; Retorna a sequência após remover os 3 primeiros itens da sequência
(drop 3 [1 2 3 4 5 6])                                      ; (4 5 6)

; Enquanto a função predicado for verdadeira, pegue o valor
(take-while #(> 4 %) [1 2 3 4 5 6])                         ; (1 2 3)

; Enquanto a função predicado for verdadeira, remova o valor
(drop-while #(> 4 %) [1 2 3 4 5 6])                         ; (4 5 6)

; Retorna o primeiro valor verdadeiro da sequência de acordo com a função predicado.
(some #(> 3 %) [1 2 3 4 5 6])                               ; true
(some #(> (:idade %) 26) [{:nome "thiago" :idade 26}
                          {:nome "Dell" :idade 27}])        ; true

; Ordena de acordo com o tipo passado
(sort [6 3 1 5 2 4])                                        ; (1 2 3 4 5 6)

; Ordena de acordo com função predicado
(sort-by count ["aaa" "bb" "cccc"])                         ; ("bb" "aaa" "cccc")

; Concatena duas sequências em uma,2
(concat [1 2] '(3 4))                                       ; (1 2 3 4)

; Calcula o tempo de cada expressão passada
(time (concat [1 2] '(3 4)))

; repete a expressão N vezes usando lazy sequence
(take 4 (repeat "A"))

; lazy-seq permite gerar sequências infinitas
(defn even-number
  ([] (even-number 0))
  ([n] (cons n (lazy-seq (even-number (+ n 2))))))

; Verifica se uma coll está vazia
(empty? [])                                                 ; true
(empty? [1 2])                                              ; true

; Retorna a própria coll passada como parâmetro
(identity [1 2])                                            ; [1 2]

; Apply serve para passar uma lista como parâmetro para funções que não aceitam lista
(apply hash-map [:x 1 :y 2])

; partial faz o curry de uma função. Você passa a função e os parâmetros iniciais dela
(def soma10 (partial + 10))
(soma10 5)                                                  ; 15

; Cria uma função negada da função passada como parâmetro
(def cheio? (complement empty?))
(empty? [1])                                                ; false
(cheio? [1])                                                ; true