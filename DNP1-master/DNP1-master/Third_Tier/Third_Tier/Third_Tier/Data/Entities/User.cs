using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace Third_Tier.Data.Entities
{
    public class User
    {
        [Key]
        public string email { get; set; }
        public string username { get; set; }
        public string password { get; set; }
        public int score { get; set; }
        public int stage { get; set; }
    }
}
