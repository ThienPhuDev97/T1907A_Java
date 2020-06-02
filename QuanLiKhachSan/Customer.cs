using System;
using System.Collections.Generic;
using System.Text;

namespace QuanLiKhachSan
{
    class Customer
    {
        public int Identitycard { get; set; }
        public string FullName { get; set; }
        public int Age { get; set; }
        public string Gender { get; set; }
        public string Address { get; set; }

        public Customer() { }
        public Customer(int identitycard,string fullname,int age,string gender,string address)
        {
            Identitycard = identitycard;
            FullName = fullname;
            Age = age;
            Gender = gender;
            Address = address;
        }
        public void display()
        {
            Console.WriteLine("Identitycard={0},Fullname={1},Age={2},Gender={3},Address={4}",Identitycard,FullName,
                Age,Gender,Address);
        }

        public void input()
        {
            Console.WriteLine("input Identitycard ");
            Identitycard = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("input fulname ");
            FullName = Console.ReadLine();
            Console.WriteLine("input age");
            Age = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("input gender");
            Gender = Console.ReadLine();
            Console.WriteLine("input Address");
            Address = Console.ReadLine();
        }
        public void input2()
        {
            
            Console.WriteLine("input fulname ");
            FullName = Console.ReadLine();
            Console.WriteLine("input age");
            Age = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("input gender");
            Gender = Console.ReadLine();
            Console.WriteLine("input Address");
            Address = Console.ReadLine();
        }
    }
}
