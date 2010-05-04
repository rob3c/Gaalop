/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datapath.graph.operations;

import datapath.graph.ModlibWriter;
import datapath.graph.OperationVisitor;
import datapath.graph.type.Type;

/**
 *
 * @author jh
 */
public class Multiplication extends BinaryOperation {

    @Override
    public String getDisplayLabel() {
        return "MULT";
    }

    public void visit(OperationVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public int getDelay() {
        Type type = getType();
        int delay = super.getDelay();
        if (type instanceof datapath.graph.type.Float) {
            delay = (type.getBitsize() == 32 ? 8 : 10); //- getStageDelay();
        }
        if(ModlibWriter.mul_pipe) {
        if(lhs.getOutputBitsize() == 21 && rhs.getOutputBitsize() == 21 && getOutputBitsize()==42)
            return 4;
        if(lhs.getOutputBitsize() <= 16 && rhs.getOutputBitsize() <= 16 && getOutputBitsize()<= 32)
            return 2;
        if(lhs.getOutputBitsize() <= 32 && rhs.getOutputBitsize() <= 32 && getOutputBitsize()<= 64)
            return 4;
        if(lhs.getOutputBitsize() <= 64 && rhs.getOutputBitsize() <= 64 && getOutputBitsize()<= 128)
            return 6;
        }
        return delay;
    }

    @Override
    public int getStageDelay() {
//        if(getOutputBitsize() > 32)
//            return 2;
//        else
        return super.getStageDelay();
    }


}
