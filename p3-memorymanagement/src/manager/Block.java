package manager;

public class Block {
	/** Three bytes of overhead */
	
	/** Indicates whether or not this block of memory is being used.
	 * A value of 0 means the block is not in use, while 1 means it is in use.
	 */
	public byte inUse; 
	/** Indicates whether or not the block of memory directly preceding this 
	 * block of memory is in use.
	 * A value of 0 means the block is not in use, while 1 means it is in use.
	 */
	public byte prevInUse;
	
	/**
	 * The size of this block of memory in bytes
	 */
	public int size;
	
	/** The part of each block of memory accessible to the user. The size of this memory is a 
	 * multiple of 4 bytes. Assume that each cell is just one byte of memory even though a reference
	 * to a String object is larger than that */
	public String[] memory;
	
	/** A pointer to the previous block in the available space list */
	public Block prevBlock;
	
	/** A pointer to the next block in the available space list */
	public Block nextBlock;
	
}
