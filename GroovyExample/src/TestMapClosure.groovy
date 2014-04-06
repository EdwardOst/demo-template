f = {a, b -> 
    println "f called ${a + b}"}

x = [ f: f ]
x.f(1, 2)