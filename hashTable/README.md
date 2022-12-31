# hashTable
This code is an implementation of a Hash Table using linear probing as a method of collision resolution. Here, I am using the function h(x)=(a*k+c)%m where a and c are constants which are provided when the function begins, m is the number of buckets which we can store and k is the key which we are inserting, removing or trying to find. You can change this equation if you like and the function will still work perfectly fine.

Hash table is very useful programming as it is a way to store data in such a way that the basic operations on that data i.e. the insertion, deletion, and searching can be performed in O(1) time which is very efficient. 

Hash table have a O(1) average complexity and O(n) worst-case time complexity. Hash table have O(n) time complexity when: 
1. If too many elements were hashed into the same key: looking inside this key may take O(n) time as you can see through my code as well.
2. Once a hash table has passed its load balance - it has to rehash (create a new bigger table and re-insert each element to the table).

However, it is said to be O(1) average case because:
1. It is very rare that many items will be hashed to the same key(if you choose a good hash function).
2. The rehash operation, which is O(n), can at most happen after n/2 ops, which are all assumed O(1): Thus when you sum the average time per op, you get: (n*O(1) + O(n)) / n) = O(1)
