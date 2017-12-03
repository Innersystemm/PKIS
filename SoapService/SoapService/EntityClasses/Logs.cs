using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Runtime.Serialization;
using System.Web;
using static SoapService.Enums.Enums;

namespace SoapService.EntityClasses
{
    [DataContract(IsReference = true)]
    public class Log
    {
        [DataMember(Name = "LogID")]
        [Key]
        public int Id { get; set; }

        [DataMember]
        public string Comment { get; set; }

        [DataMember]
        public DateTime Date { get; set; }

        [DataMember]
        public string Location { get; set; }

        [DataMember]
        public string Stack { get; set; }

        [DataMember]
        [Column(TypeName = "int")]
        public DebugLevel Level { get; set; }

        public Log(DebugLevel level, string comment, DateTime date, string location, string stack)
        {
            Level = level;
            Comment = comment;
            Date = date;
            Location = location;
            Stack = stack;
        }

        public Log() { }
    }
}