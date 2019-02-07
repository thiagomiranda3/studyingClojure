(ns firstclojure.functions)

; Função simples com um parâmetro entre colchetes. O primeiro parâmetro String é a documentação da função
(defn visitei
  [lugar]
  (str "Já visitei " lugar))

; Chamando um método
(visitei "Caxambu")

; Mostra a documentação da função
(doc hello)

; Sobrecarga de funções com aridade de parâmetros diferentes
(defn colegas
  ([]
   (str "Sem colegas"))
  ([c1]
   (str "Um colega: " c1))
  ([c1 c2]
   (str "Dois colegas: " c1 c2)))


; ################ REST PARAMETERS

; & faz o parâmetro ser recebido como uma lista
(defn visitados
  [& lugares]
  (map visitei lugares))

; Chamando um método com rest paramenter
(visitados "Caxambu" "Baependi" "Itajubá")


; ################ DESTRUCTURING

; Associa um parâmetro à uma estrutura de dados (lista, mapa, etc...)
(defn fila
  [[primeiro]]
  (str "O primeiro da fila é: " primeiro))

(fila ["Thiago" "João"])                                    ; O primeiro da fila é: Thiago

; Exemplo mais complexo de destructuring com lista
(defn fila
  [[primeiro segundo & restante]]
  (println "O primeiro e segundo são: " primeiro " e " segundo)
  (println "O restante sao: " restante))

; Destruturing com mapas
(defn coordenadas
  [{lat :lat lon :lon}]
  (str "Latitude " lat ", Longitute " lon))

; Forma mais simples, sem escolher o nome da variável
(defn coordenadas
  [{:keys [lat lon]}]
  (str "Latitude " lat ", Longitute " lon))

; Destructuring mantendo uma referência ao mapa inteiro
(defn coordenadas
  [{:keys [lon lat] :as coord}]
  (str "Latitude " lat ", Longitute " lon "Coord " coord))

(coordenadas {:lat 1.22 :lon 3.44})                         ; "Latitude 1.22, Longitute 3.44"


; ################ FUNÇÕES ANÔNIMAS

; Definindo uma função anônima com fn
(fn [nome]
  (str "Hello " nome))

; Chamando uma função anônima imediatamente após criá-la
((fn [nome] (str "Olá " nome)) "José")

; Usando uma função anônima com map
(defn cumprimentos
  [& nomes]
  (map (fn [nome]
         (str "Olá " nome)) nomes))

(cumprimentos "Thiago" "Juca" "Bonner")                     ; ("Olá Thiago" "Olá Juca" "Olá Bonner")

; Forma compacta de se definir uma função anônima #(%). Os % são os parâmetros da função
#("Olá " %)

; Função cumprimentos com modo compacto de função anônima
(defn cumprimentos
  [& nomes]
  (map #(str "Olá " %) nomes))

; Usando rest parameters com forma compacta. É usado com %&
(#(map inc %&) 1 2 3)                                       ; 2 3 4

; Função que retorna outra função. Usando notação compacta
(defn inc-maker
  [incremento]
  #(+ incremento %))

; Criando uma função personalizada e associando a uma variável
(def inc3 (inc-maker 3))
(inc3 3)                                                    ; 6

; Criando variáveis locais
(let [x 3] x)

; exemplo com rest paramenter
(def vetor ["A" "B" "C" "D" "E" "F" "G"])
(let [[primeiro & resto] vetor] [primeiro resto])           ; ["A" ("B" "C" "D" "E" "F" "G")]