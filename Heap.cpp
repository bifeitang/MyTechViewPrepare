/* Using C++ to implement MaxHeap */
#include <iostream>

using namespace std;

template <typename Item> 

class MaxHeap {
  
private:
    Item* data; 
    int count;
public:
    MaxHeap (int capacity) {
        data = new Item[capacity + 1];
        count = 0;
    }


    ~MaxHeap() {
        delete [] data;
    }

    int size() {
        return count;
    }

    bool isEmpty () {
        return count == 0;
    }
};

int main() {
    MaxHeap<int> maxHeap = MaxHeap<int>(100);
    count << maxHeap.size() << endl;

    return 0;
}
