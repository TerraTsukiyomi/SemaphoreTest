# SemaphoreTest
Моделируем ситуацияю с семафором

Java multi threads example to show you how to use Semaphore and Mutex to limit the number of threads to access resources.

Semaphores – Restrict the number of threads that can access a resource. Example, limit max 10 connections to access a file simultaneously.

Consider an ATM cubicle with 4 ATMs, Semaphore can make sure only 4 people can access simultaneously.

Output may vary, but the flow of locking and releasing should be more or less same.

Observe the above output carefully, you will see that there are maximum 4 people (C, B, F, D) to perform an operation at a time, the people A and E are waiting. As soon as one of them release the lock (D and F), A and E will acquire it and resumes immediately.




# Output
Total available Semaphore permits : 4
A : acquiring lock...
D : acquiring lock...
C : acquiring lock...
B : acquiring lock...
B : available Semaphore permits now: 4
C : available Semaphore permits now: 4
E : acquiring lock...
F : acquiring lock...
F : available Semaphore permits now: 2
F : got the permit!
F : is performing operation 1, available Semaphore permits : 1
D : available Semaphore permits now: 4
A : available Semaphore permits now: 4
D : got the permit!
D : is performing operation 1, available Semaphore permits : 0
E : available Semaphore permits now: 2
C : got the permit!
B : got the permit!
C : is performing operation 1, available Semaphore permits : 0
B : is performing operation 1, available Semaphore permits : 0
F : is performing operation 2, available Semaphore permits : 0
D : is performing operation 2, available Semaphore permits : 0
C : is performing operation 2, available Semaphore permits : 0
B : is performing operation 2, available Semaphore permits : 0
F : is performing operation 3, available Semaphore permits : 0
D : is performing operation 3, available Semaphore permits : 0
C : is performing operation 3, available Semaphore permits : 0
B : is performing operation 3, available Semaphore permits : 0
F : is performing operation 4, available Semaphore permits : 0
D : is performing operation 4, available Semaphore permits : 0
C : is performing operation 4, available Semaphore permits : 0
B : is performing operation 4, available Semaphore permits : 0
D : is performing operation 5, available Semaphore permits : 0
F : is performing operation 5, available Semaphore permits : 0
B : is performing operation 5, available Semaphore permits : 0
C : is performing operation 5, available Semaphore permits : 0


D : releasing lock...
F : releasing lock...
D : available Semaphore permits now: 1
A : got the permit!
A : is performing operation 1, available Semaphore permits : 0
F : available Semaphore permits now: 1
E : got the permit!


E : is performing operation 1, available Semaphore permits : 0
B : releasing lock...
B : available Semaphore permits now: 1
C : releasing lock...
C : available Semaphore permits now: 2
A : is performing operation 2, available Semaphore permits : 2
E : is performing operation 2, available Semaphore permits : 2
A : is performing operation 3, available Semaphore permits : 2
E : is performing operation 3, available Semaphore permits : 2
A : is performing operation 4, available Semaphore permits : 2
E : is performing operation 4, available Semaphore permits : 2
A : is performing operation 5, available Semaphore permits : 2
E : is performing operation 5, available Semaphore permits : 2
A : releasing lock...
A : available Semaphore permits now: 3
E : releasing lock...
E : available Semaphore permits now: 4



