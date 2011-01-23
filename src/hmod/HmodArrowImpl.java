/*    
Craftbook 
Copyright (C) 2010 Lymia <lymiahugs@gmail.com>

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

import com.sk89q.craftbook.access.ArrowInterface;
import com.sk89q.craftbook.access.WorldInterface;

public class HmodArrowImpl extends HmodBaseEntityImpl
                        implements ArrowInterface {
    private fc arrow;
    
    public HmodArrowImpl(fc arrow, WorldInterface w) {
        super(new BaseEntity(arrow),w);
    }

    public double getXSpeed() {
        return arrow.s;
    }
    public double getYSpeed() {
        return arrow.t;
    }
    public double getZSpeed() {
        return arrow.u;
    }

    public void setXSpeed(double s) {
        arrow.s = s;
    }
    public void setYSpeed(double s) {
        arrow.t = s;
    }
    public void setZSpeed(double s) {
        arrow.u = s;
    }
}
