package manager;

import java.util.ArrayList;

public class Manager {
	/**
	 * An array of Blocks that is used to represent the memory to be managed
	 */
	private ArrayList<Block> memory;
	/**
	 * The value of this field indicates how to search for a fit for allocated memory.
	 * A value of 0 means you should use the first fit policy, while a value of 1 means
	 * you should use the best fit policy. The default value should be 0.
	 */
	private int fitPolicy;
	
	/**
	 * This is a pointer to the head of the available blocks list
	 */
	private Block headAvailable;
	
	/**
	 * A public constructor for the Manager class
	 * @param initialBlockSizes The sizes of each block to be managed. The unit of memory is 4 bytes, so a size of
	 * 1 means 4 bytes, 2 means 8 bytes and so on. This does not include the blocks overhead.
	 * The number of sizes in blockSizes matches the number of blocks.
	 */
	public Manager(int[] initialBlockSizes) {
		//TODO
	}
	
	/**
	 * Allocate a block of memory based on the passed in size and the the fit policy.
	 * When using the best fit policy, if multiple blocks could be the best fit, use the first one 
	 * in the order the blocks are chained together in the available block list.
	 * @param size The number of units of memory to allocate
	 * @return A Block info object for the allocated memory.
	 */
	public Block malloc(int size) {
		//TODO
	}
	
	
	/**
	 * Make a previously allocated block of memory become available again. If either or both of the blocks adjacent to it are
	 * also available, join them together to form one large block.
	 * If the block passed in was not previously allocated, i.e it is not one of the blocks currently in memory indicated
	 * as being in use, return false. If the block passed in is free, return false
	 * @param block The block of memory to be deallocated
	 * @retrun true if free was successful, false otherwise
	 */
	public boolean free(Block block) {
		//TODO
	}
	
	public ArrayList<Block> getMemory() {
		return this.memory;
	}
	
	public Block getAvailableBlockList() {
		return this.headAvailable;
	}
	
	public void setFitPolicy(int fitPolicy) {
		this.fitPolicy = fitPolicy;
	}
	
	public int getFitPolicy() {
		return this.fitPolicy;
	}
}
