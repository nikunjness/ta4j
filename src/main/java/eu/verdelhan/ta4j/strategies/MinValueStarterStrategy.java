/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 Marc de Verdelhan
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package eu.verdelhan.ta4j.strategies;

import eu.verdelhan.ta4j.Indicator;
import eu.verdelhan.ta4j.Strategy;

/**
 * MinValueStarterStrategy baseia a compra em uma {@link Strategy} enviada como
 * parâmetro desde que o valor atual esteja acima do {@link start}, e baseia a
 * venda nessa mesma {@link Strategy}
 */
public class MinValueStarterStrategy extends AbstractStrategy {

    private Strategy strategy;

    private Indicator<? extends Number> indicator;

    private double start;

    public MinValueStarterStrategy(Indicator<? extends Number> indicator, Strategy strategy, double start) {
        this.strategy = strategy;
        this.start = start;
        this.indicator = indicator;
    }

    @Override
    public boolean shouldEnter(int index) {
        return (indicator.getValue(index).doubleValue() > start);
    }

    @Override
    public boolean shouldExit(int index) {
        return strategy.shouldExit(index);
    }

    @Override
    public String toString() {
        return String.format("%s start: %i", this.getClass().getSimpleName(), start);
    }
}
