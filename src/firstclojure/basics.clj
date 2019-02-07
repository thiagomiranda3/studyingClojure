(ns firstclojure.basics)

; Operadores infíxos.
(+ 1 2 3)
(- 1 2 3)
(/ 4 2)

; Concatenando strings
(str "1" "2" (+ 1 2))

; If e else
(if (> 5 4)
  (println "Verdadeiro")
  (println "Falso"))

; Colocando o do, é possível executar várias operações por condição
(if (= 1 1)
  (do (print "Condição ")
      (print "verdadeira"))
  (do (print "Condição ")
      (print "falsa")))

; If sem o else
(when (= "a" "a") "a é igual a a")

; verifica se um valor é nulo
(nil? 1)

; or retorna a primeira condição true ou última false
(or 1 2 3 4)                                                ; 1
(and 1 2 3 4)                                               ; 4

; Definição de "variável" (constante)
(def nome "Thiago Miranda")

; Vetores são definidos com colchetes
(def lista ["a" "b" "c" "d"])

; Hashmaps são definidos com chaves
(def mapa {"a" 1 "b" 2 "c" 3})

; Listas são definidas com '()
(def letras '("a", "b", "c"))

; Sets definidos com #{}
(def blacklist #{ 100, 101, 110})

; Busca uma posição no Hashmap ou vetor
(get mapa "b")                                              ; 2
(get lista 3)                                               ; d
(get blacklist 100)                                         ; 100

; Busca uma posição na lista
(nth lista 1)                                               ; b

; Cria uma nova estrutura com o valor passado. A posição depende do tipo da estrutura de dados
(conj lista "e")

; Criando listas, vetores, mapas e sets
(list "a", "b", "c")
(vector 1 2 3)
(hash-map "a" 1 "b" 2 "c" 3)
(hash-set 100 101 110)
