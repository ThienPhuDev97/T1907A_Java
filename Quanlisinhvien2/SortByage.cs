using System;
using System.Collections;
using System.Collections.Generic;
using System.Text;

namespace Quanlisinhvien2
{
    class SortByage : IComparer
    {
        public int Compare(object x, object y)
        {
            Student st1 = x as Student;
            Student st2 = y as Student;

            if(st1 == null  || st2 == null)
            {
                throw new InvalidOperationException();
            }
            return st1.Agesv < st2.Agesv ? -1 : 1;
        }
    }
}
