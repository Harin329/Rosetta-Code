; Question
; https://rosettacode.org/wiki/Top_rank_per_group#Clojure

; Usage
; clojure -M rankSalary.clj

(defstruct employee :Name :ID :Salary :Department)

(def data
  (->> '(("Lionel Messi" E10297 32000 D101)
         ("Harin Wu" E21437 47000 D050)
         ("Elon Musk" E00127 53500 D101)
         ("Taylor Swift" E63535 18000 D202)
         ("Cristiano Ronaldo" E39876 27800 D202)
         ("Jeff Bezos" E04242 41500 D101)
         ("Andres Iniesta" E01234 49500 D202)
         ("Chris Martin" E41298 21900 D050)
         ("Tiger Woods" E43128 15900 D101)
         ("Steve Jobs" E27002 19250 D202)
         ("Mario Gotze" E03033 27000 D101)
         ("Marco Reus" E10001 57000 D190)
         ("Quinn Hughes" E16398 29900 D190))
       (map #(apply (partial struct employee) %))))

(doseq [[dept emps] (group-by :Department data)]
  (println (str "Department: " dept))
  (doseq [emp (sort-by #(- (:Salary %)) emps)]
    (println (str "  " (:Name emp) " " (:Salary emp)))))
