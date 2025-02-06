import random

def suffle_values(qtd:int, size:int):
    baseValue = 65
    values_vector = []

    for value in range(0,qtd,1):
        for value in range(0,size,1):
            values_vector.append(chr(baseValue))
        
        baseValue +=1
        
    return values_vector

def create_vectors(qtd:int, size:int, vetorBase:list):

    items = suffle_values(qtd, size)
    random.shuffle(items)
    i = 0
    for iterationBase in range(0,qtd,1):
        novoVetor = []
        for value in range(0,size,1):
            novoVetor.append(items[i])
        
            i+=1
        vetorBase.append(novoVetor)

def create_tow_last_vectors(qtd:int, vetorBase:list):

    for iterationBase in range(0,qtd,1):
        novoVetor = []
        vetorBase.append(novoVetor)

def search_next_occurance(vector_base:list):
    #scan all vectors to see where the next letter will appear: do it twice for the most recurring one and the second most recurring one
   

        #define_next_target(item)
        most_recurrent_little_fuck = 0
        second_most_recurrent_little_fuck = 0

        
   
        dic={}#cria um dicionário
        # Pegando o primeiro e segundo elementos de cada sublista
        for pos_value in range(len(vector_base)):
            if vector_base[pos_value]:  # Verifica se a sublista não está vazia
                primeiro = vector_base[pos_value][0]
                segundo = vector_base[pos_value][1] if len(vector_base[pos_value]) > 1 else None  # Evita erro
                dic[pos_value] = (primeiro, segundo)  # Adiciona ao dicionário
            else:
                print(f"Sublista vazia na posição {pos_value}, pulando...")

        print(dic)
                #where to find the second most recurring one
        #define_next_target(item)

def move_next_to_match():
    #get the objet and move it, duh
    pass

def define_next_target():
    #it will firs iterate over all lists first item, then all list second items.
    #the next target will be based in a count

    pass


"""
olho pras cores que tenho 
vejo qual tem a maior quantidade nas primeiras linhas
vejo qual tem a segunda maior quantidade nas linhas seguintes
movo as cores para o backer vazio

"""



def main():
    vetorBase = []
    create_vectors(8,6,vetorBase)
    create_tow_last_vectors(2, vetorBase)

    #sort all this shit
    search_next_occurance(vetorBase)



if __name__ == '__main__':
    main() 