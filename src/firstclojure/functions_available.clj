(ns firstclojure.functions-available)

(def vetor ["A" "B" "C" "D" "E"])

; Pega as 2 primeiras posições do vetor
(take 2 vetor)

; Cria um novo vetor com os campos F e G adicionados
(into vetor ["F" "G"])

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

; Reduz um vetor ou mapa a outro tipo de dado
(reduce + [1 2 3 4 5])                                      ; 15

; incrementa o valor de cada chave do mapa e retorna um novo mapa atualizado
(reduce (fn [new-map [key val]]
          (assoc new-map key (inc val)))
        {}
        {:x 1 :y 2})

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