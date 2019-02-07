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