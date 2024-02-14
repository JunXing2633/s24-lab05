package edu.cmu.cs.cs214.rec04;

/**
 * DelegationSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions. This includes
 * attempts to add elements, not to be confused with the current size,
 * which decreases when an element is removed. This class uses delegation
 * to wrap a SortedIntList and adds functionality to track the total number
 * of attempts to add elements to the list.
 *
 * @author Nora Shoemaker
 */

public class DelegationSortedIntList implements IntegerList {
    private final SortedIntList sortedIntList; // Assuming SortedIntList is a concrete class you have that works as
                                               // expected.
    private int totalAdded;

    public DelegationSortedIntList() {
        this.sortedIntList = new SortedIntList();
        this.totalAdded = 0;
    }

    @Override
    public boolean add(int num) {
        totalAdded++; // Increment on attempt
        return sortedIntList.add(num);
    }

    @Override
    public boolean addAll(IntegerList list) {
        boolean changed = false;
        for (int i = 0; i < list.size(); i++) {
            if (add(list.get(i))) {
                changed = true;
            }
        }
        return changed;
    }

    @Override
    public int get(int index) {
        return sortedIntList.get(index);
    }

    @Override
    public boolean remove(int num) {
        return sortedIntList.remove(num);
    }

    @Override
    public boolean removeAll(IntegerList list) {
        boolean changed = false;
        for (int i = 0; i < list.size(); i++) {
            if (remove(list.get(i))) {
                changed = true;
            }
        }
        return changed;
    }

    @Override
    public int size() {
        return sortedIntList.size();
    }

    public int getTotalAdded() {
        return totalAdded;
    }
}
