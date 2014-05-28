/*
    This library is free software; you can redistribute it and/or
    modify it under the terms of the GNU General Public
    License as published by the Free Software Foundation; either
    version 2 of the license, or (at your option) any later version.
*/

package org.gjt.jclasslib.structures.attributes;

import org.gjt.jclasslib.structures.AttributeInfo;
import org.gjt.jclasslib.structures.InvalidByteCodeException;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * Describes a <tt>MethodParameter</tt> attribute structure.
 */
public class MethodParametersAttribute extends AttributeInfo {

    /**
     * Name of the attribute as in the corresponding constant pool entry.
     */
    public static final String ATTRIBUTE_NAME = "MethodParameters";

    private static final int INITIAL_LENGTH = 1;

    private MethodParametersEntry[] entries;

    /**
     * Get the list of stackMapFrame entries in the <tt>StackMapTableAttribute</tt> structure
     * as an array of <tt>BootstrapMethodsEntry</tt> structures.
     *
     * @return the array
     */
    public MethodParametersEntry[] getEntries() {
        return entries;
    }

    /**
     * Set the list of stackMapFrame entries in the <tt>StackMapTableAttribute</tt> structure
     * as an array of <tt>StackMapFrameEntry</tt> structures.
     *
     * @param entries the array
     */
    public void setMethods(MethodParametersEntry[] entries) {
        this.entries = entries;
    }

    public void read(DataInput in) throws InvalidByteCodeException, IOException {

        int numberOfEntries = in.readUnsignedByte();
        entries = new MethodParametersEntry[numberOfEntries];

        for (int i = 0; i < numberOfEntries; i++) {
            entries[i] = MethodParametersEntry.create(in, classFile);
        }

        if (debug) {
            debug("read ");
        }
    }

    public void write(DataOutput out) throws InvalidByteCodeException, IOException {
        super.write(out);

        int numberOfRefs = getLength(entries);

        out.writeShort(numberOfRefs);
        for (int i = 0; i < numberOfRefs; i++) {
            entries[i].write(out);
        }
        if (debug) {
            debug("wrote ");
        }
    }

    public int getAttributeLength() {
        int size = INITIAL_LENGTH;
        for (MethodParametersEntry entry : entries) {
            size += entry.getLength();
        }
        return size;
    }

    protected void debug(String message) {
        super.debug(message + "MethodParametersEntry attribute with " + getLength(entries) + " entries");
    }

}
